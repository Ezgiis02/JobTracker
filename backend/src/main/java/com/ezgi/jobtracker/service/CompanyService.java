package com.ezgi.jobtracker.service;

import com.ezgi.jobtracker.entity.Company;
import com.ezgi.jobtracker.repository.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;



@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id){
        Optional <Company> result=companyRepository.findById(id);

        if(result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Şirket bulunamadı "+id);
        }
        return result.get();
    }
    public Company createCompany(Company company){
        return companyRepository.save(company);
    }
    public void  deleteCompany(Long id){


        if(!companyRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Şirket bulunamadı "+id);
        }

        companyRepository.deleteById(id);
    }
    public Company updateCompany(Long id, Company updated){
        Company existing= getCompanyById(id);

        existing.setName(updated.getName());
        existing.setCity(updated.getCity());
        existing.setWebsite(updated.getWebsite());

        return companyRepository.save(existing);
    }

}
