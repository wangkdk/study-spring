package study.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class SampleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void pass() throws Exception {
        mockMvc.perform(get("/sample")
                .param("status", "pass")
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("pass ok"));
    }

    @Test
    void stop() throws Exception {
        mockMvc.perform(get("/sample")
                .param("status", "stop")
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").doesNotExist());
    }
}
