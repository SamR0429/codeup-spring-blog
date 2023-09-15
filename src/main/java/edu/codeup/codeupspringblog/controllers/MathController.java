package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MathController {

    @GetMapping("/add/{number1}/and/{number2}")
    @ResponseBody

    public String adding(@PathVariable double number1, @PathVariable double number2) {
        double add = Math.abs(number1 + number2);
        return String.format("%s + %s = %s", number1, number2, add);
    }

    @GetMapping("/subtract/{number1}/from/{number2}")
    @ResponseBody
    public String subtracting(@PathVariable double number1, @PathVariable double number2) {
        double sub = Math.abs(number2 - number1);
        return String.format("%s - %s = %s", number2, number1, sub);
    }


    @GetMapping("/multiply/{number1}/and/{number2}")
    @ResponseBody
    public String multiplication(@PathVariable double number1, @PathVariable double number2){
        double mult = Math.abs(number1 * number2);
        return String.format("%s * %s = %s", number1, number2, mult);
    }


    @GetMapping("/divide/{number1}/by/{number2}")
    @ResponseBody
    public String division(@PathVariable double number1, @PathVariable double number2){
        double divide = Math.abs(number1 / number2);
        return String.format("%s / %s = %s", number1, number2, divide);
    }

}
