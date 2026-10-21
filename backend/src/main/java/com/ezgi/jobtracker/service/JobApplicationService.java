package com.ezgi.jobtracker.service;

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

    public JobApplicationService(JobApplicationRepository jobApplicationRepository){
        this.jobApplicationRepository=jobApplicationRepository;
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





}
