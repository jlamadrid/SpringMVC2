package com.enlightendev.spring.core.controller;

import com.enlightendev.spring.core.domain.Company;
import com.enlightendev.spring.core.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
    public String findByName(@PathVariable String name, Model model){

        List<Company> result = companyService.query(name);
        model.addAttribute("company", result.get(0));
        return "company/company";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findByID(@PathVariable int id, Model model){

        Company result = companyService.findByID(id);
        model.addAttribute("company", result);
        return "company/company";
    }
}