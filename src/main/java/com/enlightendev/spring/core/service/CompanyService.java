package com.enlightendev.spring.core.service;

import com.enlightendev.spring.core.domain.Company;
import java.util.List;

public interface CompanyService {

    public Company create(Company company);

    public Company update(Company company);

    public Company query(String companyName);

    public Company findById(Long id);

    public void delete(Long id);

    public List<Company> findAll();

}
