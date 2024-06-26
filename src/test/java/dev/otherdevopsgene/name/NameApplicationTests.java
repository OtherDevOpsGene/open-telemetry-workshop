package dev.otherdevopsgene.name;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.opentelemetry.api.GlobalOpenTelemetry;

@SpringBootTest
class NameApplicationTests {

  @BeforeEach
  public void setUp() {
    GlobalOpenTelemetry.resetForTest(); // Reset the global instance before each test
  }
  
  @Test
  void contextLoads() {}
}
