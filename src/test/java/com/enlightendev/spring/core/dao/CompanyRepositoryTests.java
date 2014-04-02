package com.enlightendev.spring.core.dao;

import com.enlightendev.spring.config.AppConfig;
import com.enlightendev.spring.config.DataConfig;
import com.enlightendev.spring.config.MyWebAppInitializer;
import com.enlightendev.spring.core.domain.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * http://spring.io/blog/2011/06/21/spring-3-1-m2-testing-with-configuration-classes-and-profiles/
 * http://docs.spring.io/spring/docs/3.1.0.M2/spring-framework-reference/html/testing.html#testcontext-framework
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(classes = {MyWebAppInitializer.class, AppConfig.class, DataConfig.class})
public class CompanyRepositoryTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void getCompanies(){
        List<Company> companies = companyRepository.findAll();
        assertEquals(0,companies.size());
    }

    @Test
    public void createCompanies(){

        companyRepository.save(new Company("CO1","CO1","NYSE"));
        companyRepository.save(new Company("CO2","CO2","NYSE"));

        List<Company> companies = companyRepository.findAll();
        assertEquals(2,companies.size());

    }

}