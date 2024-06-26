package dev.otherdevopsgene.name;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Scope;

@RestController
public class NameController {

  private static final Logger log = LoggerFactory.getLogger(NameController.class);
  private final Tracer tracer;

  @Autowired
  NameController(OpenTelemetry openTelemetry) {
    tracer = openTelemetry.getTracer(NameController.class.getName(), "0.1.0");
  }
  
  @GetMapping("/")
  public String hello(@RequestParam String firstname, @RequestParam String surname) {
    log.info("Got firstname=[{}], surname=[{}]", firstname, surname);
    
    Span span = tracer.spanBuilder("hello").startSpan();
    span.setAttribute("firstname", firstname);
    span.setAttribute("surname", surname);

    // Make the span the current span
    try (Scope scope = span.makeCurrent()) {
      
      final StringBuilder message = new StringBuilder("Hello ");
      message.append(firstname).append('\n');
  
      return message.toString();
    } catch(Throwable t) {
      span.setStatus(StatusCode.ERROR, "Something bad happened!");
      span.recordException(t);
    } finally {
      span.end();
    }
  }
}
