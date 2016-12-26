package com.kensuka.bills.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kmukai on 10/5/2016.
 */
@Controller
public class GreetingController {

    @RequestMapping(value = "/greeting")
    @ResponseBody
    public String greeting(){
        return "Hola Kenji";
    }
}
