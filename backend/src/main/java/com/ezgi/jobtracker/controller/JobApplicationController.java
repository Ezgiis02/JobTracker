package com.ezgi.jobtracker.controller;

import com.ezgi.jobtracker.dto.JobApplicationRequest;
import com.ezgi.jobtracker.entity.JobApplication;
import com.ezgi.jobtracker.service.JobApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService){
        this.jobApplicationService=jobApplicationService;
    }

    @GetMapping
    public List<JobApplication> getAllJobApplication(){
        return jobApplicationService.getAllJobApplications();
    }

    @GetMapping("/{id}")
    public JobApplication getJobApplicationById(@PathVariable Long id){
        return jobApplicationService.getApplicationById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobApplication createApplication(@RequestBody JobApplicationRequest request){
        return jobApplicationService.createJobApplication(request);
    }


}
