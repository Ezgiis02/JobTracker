package com.ezgi.jobtracker.controller;


import com.ezgi.jobtracker.entity.Company;
import com.ezgi.jobtracker.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this. companyService=companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies(){
       return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id){
        return companyService.getCompanyById(id);
    }
}
