package com.enlightendev.spring.core.service;

import com.enlightendev.spring.core.dao.CompanyRepository;
import com.enlightendev.spring.core.domain.Company;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(){}


    @Override
    @Transactional
    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company) {
        Company updatedCompany = companyRepository.findOne(company.getId());

        updatedCompany.setName(company.getName());
        updatedCompany.setTicker(company.getTicker());

        return updatedCompany;
    }

    @Override
    public Company query(String companyName) {

        Company company = companyRepository.findByName(companyName);
        return company;
    }

    @Override
    public Company findById(Long id) {

        Company company = companyRepository.findOne(id);
        return company;
    }

    @Override
    public void delete(Long id) {
        companyRepository.delete(id);
    }

    @Override
    public List<Company> findAll() {

        List<Company> list = Lists.newArrayList(companyRepository.findAll());
        return list;
    }
}
