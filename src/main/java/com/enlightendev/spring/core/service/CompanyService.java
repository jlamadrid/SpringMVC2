package com.enlightendev.spring.core.service;

import com.enlightendev.spring.core.domain.Company;
import java.util.List;

/**
 * Created by Juan on 3/21/14.
 */
public interface CompanyService {

    public List<Company> query(String companyName);

    public Company findByID(int id);

    public void removeByID(int id);

    public List<Company> getAll();

}
