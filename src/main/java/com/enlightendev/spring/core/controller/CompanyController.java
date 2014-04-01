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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("companies", companyService.findAll());
        return "company/list";
    }

    @RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
    public String findByName(@PathVariable String name, Model model){

        Company result = companyService.query(name);
        model.addAttribute("company", result);
        return "company/company";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findByID(@PathVariable Long id, Model model){

        Company result = companyService.findById(id);
        model.addAttribute("company", result);
        return "company/company";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        companyService.delete(id);
        return "redirect:/companies/list";
    }

    @RequestMapping(value = "/byExchange/{exchange}", method = RequestMethod.GET)
    public String findByExchange(@PathVariable String exchange, Model model){

        List<Company> result = companyService.findByExchange(exchange);
        model.addAttribute("companies", result);
        return "company/list";
    }

    @RequestMapping(value = "/allNYSE", method = RequestMethod.GET)
    public String findByExchange(Model model){

        List<Company> result = companyService.allNYSE();
        model.addAttribute("companies", result);
        return "company/list";
    }

    @RequestMapping(value = "/init")
    public String init(){

        companyService.create(new Company("Company 1", "CO1", "Nasdaq"));
        companyService.create(new Company("Company 2", "CO2", "Nasdaq"));
        companyService.create(new Company("Company 3", "CO3", "NYSE"));
        companyService.create(new Company("Company 4", "CO4", "NYSE"));

        return "redirect:/companies/list";
    }
}