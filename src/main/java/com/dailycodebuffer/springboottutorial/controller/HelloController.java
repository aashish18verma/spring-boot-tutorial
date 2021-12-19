package com.dailycodebuffer.springboottutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@PropertySource() for other property you want to create
    @Value("${some.config}")
    private String WelcomeMessage ;

    @GetMapping("/")
    public String HelloWorld(){
        return  WelcomeMessage;
    }
}
