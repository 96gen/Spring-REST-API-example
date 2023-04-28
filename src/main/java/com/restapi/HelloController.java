package com.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //HTTP Get Request
    //http://localhost:8080/
    @GetMapping("/")
    public String helloWorld(){
        return "Hello World!";
    }
}
