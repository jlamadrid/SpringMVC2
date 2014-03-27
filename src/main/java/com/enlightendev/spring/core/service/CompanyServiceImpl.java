package com.enlightendev.spring.core.service;

import com.enlightendev.spring.core.domain.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan on 3/21/14.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    private List<Company> companies;

    public CompanyServiceImpl(){

        companies = new ArrayList<Company>();
        companies.add(new Company("Company 1",1));
        companies.add(new Company("Company 2",2));

    }


    @Override
    public List<Company> query(String companyName) {
        List<Company> result = new ArrayList<Company>();
        for (Company company: companies ){
            if(company.getName().equals(companyName)){
                result.add(company);
            }
        }

        return result;
    }

    @Override
    public Company findByID(int id) {
        for (Company company: companies ){
            if(company.getId() == id){
                return company;
            }
        }
        return new Company("No company found",0);
    }

    @Override
    public void removeByID(int id) {
        for (Company company: companies ){
            if(company.getId() == id){
                companies.remove(company);
            }
        }
    }

    @Override
    public List<Company> getAll() {
        return companies;
    }
}
