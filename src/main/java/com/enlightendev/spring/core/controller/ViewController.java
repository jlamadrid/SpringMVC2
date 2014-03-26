package com.enlightendev.spring.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Juan on 3/26/14.
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping(method = RequestMethod.GET)
    public String showMe(){

        return "show";
    }
}
