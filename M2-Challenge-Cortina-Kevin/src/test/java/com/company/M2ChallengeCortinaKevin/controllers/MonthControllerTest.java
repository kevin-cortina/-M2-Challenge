package com.company.M2ChallengeCortinaKevin.controllers;


import com.company.M2ChallengeCortinaKevin.controller.MonthController;
import com.company.M2ChallengeCortinaKevin.models.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)

public class MonthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    public MonthControllerTest() {
    }

    @Test
    public void shouldReturnSuccessfulResponse() throws Exception {
        Month monthNumber = new Month();
        String inputJson = mapper.writeValueAsString(monthNumber);
        mockMvc.perform(
                        get("/month/5")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnUnsuccessfulResponseWithHighNumber() throws Exception {
        Month monthNumber = new Month();
        String inputJson = mapper.writeValueAsString(monthNumber);
        mockMvc.perform(
                        get("/month/13")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnUnsuccessfulResponseWithLowNumber() throws Exception {
        Month monthNumber = new Month();
        String inputJson = mapper.writeValueAsString(monthNumber);
        mockMvc.perform(
                        get("/month/-1")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnRandomMonth() throws Exception {
        Month monthNumber = new Month();
        String inputJson = mapper.writeValueAsString(monthNumber);
        mockMvc.perform(
                        get("/randomMonth")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void contextLoads() {
    }

}

