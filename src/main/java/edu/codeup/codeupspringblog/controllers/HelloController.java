package edu.codeup.codeupspringblog.controllers;


import edu.codeup.codeupspringblog.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hello")
//if you take this out you'd have to have the /hello for every single method, doing it this way just makes it easier to read and neater
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


    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name); // the first arg. is what you are using in the getmapping method, and then you're putting the variable you declared in the method
        return "hello"; //view that you are trying to render
    }


    //these two methods are talking to the join html and rendering the input by doing a Postmapping from the Getmapping
    @GetMapping("/join")
    public String showJoinForm(Model model) {
        List<Item> shoppingCart = new ArrayList<>();
        shoppingCart.add(new Item("screwdriver"));
        shoppingCart.add(new Item("hammer"));
        shoppingCart.add(new Item("drill"));
        model.addAttribute("shoppingCart", shoppingCart);
        return "join";
    }


    //you can have multiple postmethods for each getMapping method
    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "welcome to " + cohort + "!");
        return "join";
    }

}
