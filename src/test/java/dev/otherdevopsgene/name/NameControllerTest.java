package dev.otherdevopsgene.name;

import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class NameControllerTest {

  @Autowired private MockMvc mvc;

  @Test
  public void getName() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/")
        .param("firstname", "Gene")
        .param("surname", "Gotimer")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(startsWith("Hello Gene")));
  }
}
