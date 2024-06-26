package dev.otherdevopsgene.name;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

  final Logger log = LoggerFactory.getLogger(NameController.class);
    
  @GetMapping("/")
  public String hello(@RequestParam String firstname, @RequestParam String surname) {
    log.info("Got firstname=[{}], surname=[{}]", firstname, surname);
    
    final StringBuilder message = new StringBuilder("Hello ");
    message.append(firstname).append('\n');

    return message.toString();
  }
}
