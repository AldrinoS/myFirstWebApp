package com.example.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    //E:\codes\springboot\myfirstwebapp\src\main\resources\META-INF\resources\WEB-INF\jsp\sayHello.jsp
    @RequestMapping("say-hello-jsp")
    public String sayHelloHtml() {
        return "sayHello";
    }
}
