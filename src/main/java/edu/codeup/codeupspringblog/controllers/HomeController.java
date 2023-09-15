package edu.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    //this was the old and the bottom one is thyme leaf
//    @GetMapping("/")
//    @ResponseBody
//    public String landingPage() {
//        return "This is the landing page!";
//    }


    @GetMapping("/home")
    public String welcome() {
//        thyme leaf knows its supposed to render this method cause of the return "home" it has to be named identically to work
        return "home";
    }


}
