package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String hello(){
        return "Hello Goutham";
    }
    @GetMapping("/about")
    public String about(){
        return "this is a great project";
    }
}
