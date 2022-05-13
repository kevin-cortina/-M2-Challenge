package com.company.M2ChallengeCortinaKevin.controller;

import com.company.M2ChallengeCortinaKevin.models.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

@RestController
public class MonthController {

    private static Month[] months = {
            new Month(0, "January"),
            new Month(1, "February"),
            new Month(2, "March"),
            new Month(3, "April"),
            new Month(4, "May"),
            new Month(5, "June"),
            new Month(6, "July"),
            new Month(7, "August"),
            new Month(8, "September"),
            new Month(9, "October"),
            new Month(10, "November"),
            new Month(11, "December"),
    };

    //get month by Month number
    @RequestMapping(value ={"/month/{monthNumber}"},method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getMonthByNumber(@PathVariable int monthNumber){
        if(monthNumber == 1) {
            return "1-January";
        } else if (monthNumber == 2) {
            return "2-February";
        } else if (monthNumber == 3) {
            return "3-March";
        } else if (monthNumber == 4) {
            return "4-April";
        } else if (monthNumber == 5) {
            return "5-May";
        } else if (monthNumber == 6) {
            return "6-June";
        } else if (monthNumber == 7) {
            return "7-July";
        } else if (monthNumber == 8) {
            return "8-August";
        } else if (monthNumber == 9) {
            return "9-September";
        } else if (monthNumber == 10) {
            return "10-October";
        } else if (monthNumber == 11) {
            return "11-November";
        } else if (monthNumber == 12) {
            return "12-December";
        } else if (monthNumber <= 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Month Number Specified");
        } else if (monthNumber >= 12) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Month Number Specified");
        }
        return null;
    }

    //get a random Month
    @RequestMapping(value ={"/randomMonth"}, method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Month getRandomMonth() {
        Random rand = new Random();
        return months[rand.nextInt(11)];
    }

}
