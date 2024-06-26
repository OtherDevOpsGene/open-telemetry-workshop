package dev.otherdevopsgene.name;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NameApplication {

  final static Logger log = LoggerFactory.getLogger(NameApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(NameApplication.class, args);
    
    log.info("Started NameApplication");
  }
}
