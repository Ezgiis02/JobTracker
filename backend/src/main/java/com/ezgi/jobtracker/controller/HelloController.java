package com.ezgi.jobtracker.controller;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Merhaba Ezgi!";
    }

    @GetMapping("/info")
    public Map<String, String> info(){
        return Map.of(
          "app","Job Tracker",
          "developer","Ezgi"
        );
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        return "Merhaba "+ name+ "!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue="misafir") String name){
        return "Merhaba "+name+"!";
    }
}
