package com.goit10.mod13bSpringDevMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTest(){

        System.out.println("Hello Word");
        return "Hello Word";
    }

}