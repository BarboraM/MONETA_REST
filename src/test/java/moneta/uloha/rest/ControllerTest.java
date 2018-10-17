package moneta.uloha.rest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Test
    public void testTransformText() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        mockMvc.perform(post("/moneta/transform")
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .content("Ahoj"))
                .andExpect(status().isOk())
                .andExpect(content().string("JoHa"));
    }
}
