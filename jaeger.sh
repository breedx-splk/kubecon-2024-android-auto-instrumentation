#!/bin/bash

docker run -it --rm  \
  -e COLLECTOR_OTLP_ENABLED=true \
  -e COLLECTOR_OTLP_HTTP_HOST_PORT=0.0.0.0:4318 \
  -p 4318:4318 \
  -p 16686:16686 \
  jaegertracing/all-in-one:1.60