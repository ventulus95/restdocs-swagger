package com.ventulus95.restdocsswagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/test")
    public Map<String, String> test(){
        return Map.of("1", "1");
    }

}
