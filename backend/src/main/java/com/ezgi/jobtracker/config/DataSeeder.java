package com.ezgi.jobtracker.config;

import com.ezgi.jobtracker.entity.Company;
import com.ezgi.jobtracker.repository.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataSeeder implements CommandLineRunner {


    private final CompanyRepository companyRepository;

    public DataSeeder(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public void run(String... args) {
        companyRepository.save(new Company("ASELSAN", "Ankara", "aselsan.com"));
        companyRepository.save(new Company("HAVELSAN", "Ankara", "havelsan.com.tr"));
        companyRepository.save(new Company("ROKETSAN", "Ankara", "roketsan.com.tr"));

        System.out.println("Şirket sayısı: " + companyRepository.count());

        for (Company company : companyRepository.findAll()) {
            System.out.println(company.getId() + " - " + company.getName());
        }
    }

}