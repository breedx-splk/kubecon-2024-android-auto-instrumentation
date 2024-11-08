package io.opentelemetry.example.skyfanatic

import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.Executors
import java.util.function.Consumer

fun makeClient(): OkHttpClient {
    return OkHttpClient()
        .newBuilder()
        .build();
}

class IconFetcher(
    private val okhttp: OkHttpClient = makeClient()
) {
    private val pool = Executors.newSingleThreadExecutor()

    fun fetch(onComplete: (String) -> Unit) {
        pool.submit {
            val req = Request.Builder()
                .get()
                .url("http://10.0.2.2:9000/item")
                .build()
            val res = okhttp.newCall(req).execute()
            res.use {
                val body = res.body?.string()
                body?.let { it1 -> onComplete(it1) } ?: "?"
            }
        }
    }
}