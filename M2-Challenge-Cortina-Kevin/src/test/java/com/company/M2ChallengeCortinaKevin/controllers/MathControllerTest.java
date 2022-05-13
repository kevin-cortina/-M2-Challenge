package com.company.M2ChallengeCortinaKevin.controllers;

import com.company.M2ChallengeCortinaKevin.controller.MathController;
import com.company.M2ChallengeCortinaKevin.models.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();
    
    @Test
    public void shouldSuccessDoSomeAddition() throws Exception {

        // ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(20);
        inputSolution.setOperand2(5);
        inputSolution.setAnswer(25);
        inputSolution.setOperation("add");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputSolution);

        // ACT
        mockMvc.perform(
                        post("/add")                            // Perform the POST request.
                                .content(inputJson)                           // Set the request body.
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    @Test
    public void shouldSuccessDoSomeSubtraction() throws Exception {

        // ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(20);
        inputSolution.setOperand2(5);
        inputSolution.setAnswer(15);
        inputSolution.setOperation("subtract");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputSolution);

        // ACT
        mockMvc.perform(
                        post("/subtract")                            // Perform the POST request.
                                .content(inputJson)                           // Set the request body.
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    @Test
    public void shouldSuccessDoSomeMultiplication() throws Exception {

        // ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(4);
        inputSolution.setOperand2(5);
        inputSolution.setAnswer(20);
        inputSolution.setOperation("multiply");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputSolution);

        // ACT
        mockMvc.perform(
                        post("/multiply")                            // Perform the POST request.
                                .content(inputJson)                           // Set the request body.
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    @Test
    public void shouldSuccessDoSomeDivision() throws Exception {

        // ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(20);
        inputSolution.setOperand2(5);
        inputSolution.setAnswer(4);
        inputSolution.setOperation("divide");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputSolution);

        // ACT
        mockMvc.perform(
                        post("/divide")                            // Perform the POST request.
                                .content(inputJson)                           // Set the request body.
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    @Test
    public void shouldUnsuccessfulDivision() throws Exception {
        // ARRANGE
        MathSolution inputSolution = new MathSolution(
                20,A,5,"divide");
        // ACT
        mockMvc.perform(
                        post("/divide")                            // Perform the POST request.
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isUnprocessableEntity());          // ASSERT
    }

    @Test
    public void shouldUnsuccessfulDivisionBecauseOfZero() throws Exception {
        // ARRANGE
        MathSolution inputSolution = new MathSolution(
                20,0,5,"divide");
        // ACT
        mockMvc.perform(
                        post("/divide")                            // Perform the POST request.
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isUnprocessableEntity());          // ASSERT
    }

    @Test
    public void shouldUnsuccessfulMultiplication() throws Exception {
        // ARRANGE
        MathSolution inputSolution = new MathSolution(
                20,0,5,"divide");
        // ACT
        mockMvc.perform(
                        post("/divide")                            // Perform the POST request.
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isUnprocessableEntity());          // ASSERT
    }

    @Test
    public void shouldUnsuccessfulSubtraction() throws Exception {
        // ARRANGE
        MathSolution inputSolution = new MathSolution(
                20,X,5,"divide");
        // ACT
        mockMvc.perform(
                        post("/divide")                            // Perform the POST request.
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isUnprocessableEntity());          // ASSERT
    }

    @Test
    public void shouldUnsuccessfulAddition() throws Exception {
        // ARRANGE
        MathSolution inputSolution = new MathSolution(
                20,A,5,"divide");
        // ACT
        mockMvc.perform(
                        post("/divide")                            // Perform the POST request.
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isUnprocessableEntity());          // ASSERT
    }

}
