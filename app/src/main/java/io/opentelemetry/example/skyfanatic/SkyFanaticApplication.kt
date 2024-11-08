package io.opentelemetry.example.skyfanatic

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import io.opentelemetry.android.OpenTelemetryRum
import io.opentelemetry.android.OpenTelemetryRumBuilder
import io.opentelemetry.android.config.OtelRumConfig
import io.opentelemetry.android.features.diskbuffering.DiskBufferingConfiguration
import io.opentelemetry.api.common.AttributeKey.stringKey
import io.opentelemetry.api.common.Attributes
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter

class SkyFanaticApplication : Application() {

    @SuppressLint("RestrictedApi")
    override fun onCreate() {
        super.onCreate()

        Log.i("sky-fanatic", "Initializing the opentelemetry-android-agent")
        val config =
            OtelRumConfig()
                .setGlobalAttributes(Attributes.of(stringKey("author"), "jason"))

        // 10.0.2.2 is apparently a special binding to the host running the emulator
        val spansIngestUrl = "http://10.0.2.2:4318/v1/traces" // jaeger
        val otelRumBuilder: OpenTelemetryRumBuilder =
            OpenTelemetryRum.builder(this, config)
                .addSpanExporterCustomizer {
                    OtlpHttpSpanExporter.builder()
                        .setEndpoint(spansIngestUrl)
                        .build()
                }
        try {
            rum = otelRumBuilder.build()
            Log.d("sky-fanatic", "RUM session started: " + rum!!.rumSessionId)
        } catch (e: Exception) {
            Log.e("sky-fanatic", "Oh no!", e)
        }
    }

    companion object {
        var rum: OpenTelemetryRum? = null
    }
}
