package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DistanceController {

    @GetMapping("/distance/{number}")
    @ResponseBody
    public String distanceFromTwelve(@PathVariable double number){
        double distanceFromTwelve = Math.abs(12- number);
//       the results is showing 12 cause you hard coded 12 you can change it any number you like
        return String.format("%s is %s away from 12", number, distanceFromTwelve);
    }

    @GetMapping("/distance/{number1}/{number2}")
    @ResponseBody
    public String distanceBetweenNumbers(@PathVariable double number1, @PathVariable double number2){
        double distance = Math.abs(number1- number2);
        return String.format("%s is %s away from %s", number1, distance , number2);
    }


}
