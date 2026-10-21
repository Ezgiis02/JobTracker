package com.ezgi.jobtracker.service;

import com.ezgi.jobtracker.dto.JobApplicationRequest;
import com.ezgi.jobtracker.entity.Company;
import com.ezgi.jobtracker.entity.JobApplication;
import com.ezgi.jobtracker.repository.JobApplicationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final CompanyService companyService;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository,CompanyService companyService){
        this.jobApplicationRepository=jobApplicationRepository;
        this.companyService=companyService;
    }

    public List<JobApplication> getAllJobApplications(){
        return jobApplicationRepository.findAll();
    }

    public JobApplication getApplicationById(Long id){
        Optional<JobApplication> result= jobApplicationRepository.findById(id);

        if(result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Başvuru bulunamadı: "+id);
        }
        return result.get();
    }

    public JobApplication createJobApplication(JobApplicationRequest request){
        Company company= companyService.getCompanyById(request.companyId());

        JobApplication application= new JobApplication(
                company,
                request.position(),
                request.applicationDate(),
                request.status(),
                request.notes()
        );
        return jobApplicationRepository.save(application);
    }



}
