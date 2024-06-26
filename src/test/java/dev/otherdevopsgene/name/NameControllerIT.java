package dev.otherdevopsgene.name;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NameControllerIT {

  @Autowired private TestRestTemplate template;

  @Test
  public void getHello() throws Exception {
    Map<String, String> params = new HashMap<String, String>();
    params.put("firstname", "Gene");
    params.put("surname", "Gotimer");
        
    ResponseEntity<String> response = template.getForEntity("/?firstname={firstname}&surname={surname}", String.class, params);
    assertThat(response.getBody()).startsWith("Hello Gene");
  }
}
