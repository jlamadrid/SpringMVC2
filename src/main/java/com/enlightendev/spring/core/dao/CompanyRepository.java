package com.enlightendev.spring.core.dao;

import com.enlightendev.spring.core.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    public Company findByName(String name);

    @Query("select c from Company c where c.exchange = 'NYSE'")
    public List<Company> allNYSE();

    @Query("select c from Company c where c.exchange = ?1")
    public List<Company> findByExchange(String exchange);

}