package com.testowy.projectUser.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "Hello Gosia";
    }

    @GetMapping("/sayHello")
    public String sayHello(){
        return "sayHello";
    }
}
