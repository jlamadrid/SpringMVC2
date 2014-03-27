package com.enlightendev.spring.core.dao;

import com.enlightendev.spring.core.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    public Company findByName(String name);

}
