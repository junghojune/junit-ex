package com.hosu.testpractice.test3;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.hosu.testpractice.test3.controller.TicketController;
import com.hosu.testpractice.test3.service.TicketingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(TicketController.class)
public class MockitoExampleTest5 {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    TicketingService ticketingService;

    @DisplayName("WebMvcTest를 이용한 Controller Test")
    @Test
    public void ticketingControllerTest() throws Exception {
        // given
        String contents = "Test";

        mockMvc.perform(get("/ticket"))
                .andExpect(status().isOk())
                .andExpect(content().string(contents));
    }
}
