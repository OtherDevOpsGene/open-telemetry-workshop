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
  OTEL-SERVICE_NAME=name-server \
  OTEL_TRACES_EXPORTER=logging \
  OTEL_METRICS_EXPORTER=logging \
  OTEL_LOGS_EXPORTER=logging \
  OTEL_METRIC_EXPORT_INTERVAL=60000
$ mvn spring-boot:run
```

From another window:

```console
$ curl "http://localhost:8080/?firstname=Jeremiah&surname=Bullfrog"
```
