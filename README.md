# open-telemetry-workshop

From KCDC2024


## Building

```console
$ mvn clean verify
```

## Running

```console
$ curl -L -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar
$ export JAVA_TOOL_OPTIONS="-javaagent:/home/ec2-user/environment/opentelemetry-javaagent.jar" \
  OTEL_SERVICE_NAME=name-server \
  OTEL_TRACES_EXPORTER=otlp \
  OTEL_METRICS_EXPORTER=otlp \
  OTEL_LOGS_EXPORTER=otlp \
  OTEL_METRIC_EXPORT_INTERVAL=60000 \
  OTEL_EXPORTER_OTLP_PROTOCOL=grpc \
  OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:4317
$ mvn spring-boot:run
```

From another window:

```console
$ docker run --rm -it -p 18888:18888 -p 4317:18889 -d -e DOTNET_DASHBOARD_UNSECURED_ALLOW_ANONYMOUS=true --name aspire-dashboard mcr.microsoft.com/dotnet/nightly/aspire-dashboard:8.0.0-preview.5
$ curl "http://localhost:8080/?firstname=Jeremiah&surname=Bullfrog"
```
