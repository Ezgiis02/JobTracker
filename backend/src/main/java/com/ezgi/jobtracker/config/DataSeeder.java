package com.ezgi.jobtracker.config;

import com.ezgi.jobtracker.entity.ApplicationStatus;
import com.ezgi.jobtracker.entity.Company;
import com.ezgi.jobtracker.entity.JobApplication;
import com.ezgi.jobtracker.repository.CompanyRepository;
import com.ezgi.jobtracker.repository.JobApplicationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataSeeder implements CommandLineRunner {


    private final CompanyRepository companyRepository;
    private final JobApplicationRepository jobApplicationRepository;

    public DataSeeder(CompanyRepository companyRepository,JobApplicationRepository jobApplicationRepository) {
        this.companyRepository = companyRepository;
        this.jobApplicationRepository=jobApplicationRepository;
    }


    @Override
    public void run(String... args) {
        Company aselsan=companyRepository.save(new Company("ASELSAN", "Ankara", "aselsan.com"));
        Company havelsan =companyRepository.save(new Company("HAVELSAN", "Ankara", "havelsan.com.tr"));
        Company roketsan=companyRepository.save(new Company("ROKETSAN", "Ankara", "roketsan.com.tr"));

        jobApplicationRepository.save(new JobApplication(aselsan,"AI Engineer", LocalDate.of(2026,10,1), ApplicationStatus.INTERVIEW,"Teknik mülakat 25 Ekim"));
        jobApplicationRepository.save(new JobApplication(aselsan,"Yazılım Mühendisi", LocalDate.of(2026,10,5), ApplicationStatus.APPLIED,null));
        jobApplicationRepository.save(new JobApplication(havelsan, "Backend Developer",LocalDate.of(2026, 9, 20), ApplicationStatus.OFFER, "Teklif değerlendiriliyor"));

        jobApplicationRepository.save(new JobApplication(roketsan, "Java Developer", LocalDate.of(2026, 9, 10), ApplicationStatus.REJECTED, null));

        System.out.println("Şirket sayısı: " + companyRepository.count());
        System.out.println("Başvuru sayısı: " + jobApplicationRepository.count());

    }
}