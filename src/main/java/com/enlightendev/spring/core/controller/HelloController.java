package com.enlightendev.spring.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {


	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
	public String sayHello() {
        return "Hello Juan";
	}

    @RequestMapping(value = "/goodbye", method = RequestMethod.GET)
    @ResponseBody
    public String sayGoodbye() {
        return "Bye Juan ";
    }
}