package com.company.M2ChallengeCortinaKevin.controller;

import com.company.M2ChallengeCortinaKevin.models.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;


@RestController
public class MathController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int mathAddition(@RequestBody MathSolution additionSol) {
        if(additionSol == null) {
            throw new RestClientException("Parameters cannot be null");
        }
        return MathSolution.addition();
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int mathSubtraction(@RequestBody MathSolution subtractionSol) {
        if(subtractionSol == null) {
            throw new RestClientException("Parameters cannot be null");
        }
        return MathSolution.subtraction();
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int mathMultiplication(@RequestBody MathSolution multiplicationSol) {
        if(multiplicationSol == null) {
            throw new RestClientException("Parameters cannot be null");
        }
        return MathSolution.multiplication();
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int mathDivision(@RequestBody MathSolution divisionSol) {
        if(divisionSol == null) {
            throw new RestClientException("Parameters cannot be null");
        }
               return MathSolution.division();
        }

    }
