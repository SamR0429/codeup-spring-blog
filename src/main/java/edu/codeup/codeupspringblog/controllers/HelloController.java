package edu.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")     //if you take this out you'd have to have the /hello for every single method, doing it this way just makes it easier to read and neater
public class HelloController {

//    both of these are the same, its just you made them to show you can just have a regular one /XXXXX
//
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello";
//
//    }
//
//    @GetMapping("/hello/world")
//    @ResponseBody
//    public String helloWorld() {
//        return "Hello World";
//    }
//
//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String helloName(@PathVariable String name) {
//        return name;
////        both of these are the same, just a formatting difference
////        return String.format("hello, %s!", name);
//    }


//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello";
//
//    }

    @GetMapping("/world")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name) {
        return name;
//        both of these are the same, just a formatting difference
//        return String.format("hello, %s!", name);
    }

    //the following we moved to the distance controller that holds these methods

//    @GetMapping("/distance/{number}")
//    @ResponseBody
//    public String distanceFromTwelve(@PathVariable double number){
//       double distanceFromTwelve = Math.abs(12- number);
////       the results is showing 12 cause you hard coded 12 you can change it any number you like
//       return String.format("%s is %s away from 12", number, distanceFromTwelve);
//    }
//
//    @GetMapping("/distance/{number1}/{number2}")
//    @ResponseBody
//    public String distanceBetweenNumbers(@PathVariable double number1, @PathVariable double number2){
//        double distance = Math.abs(number1- number2);
//        return String.format("%s is %s away from %s", number1, distance , number2);
//    }


}
