package com.ezgi.jobtracker.dto;

import com.ezgi.jobtracker.entity.ApplicationStatus;

import java.time.LocalDate;

public record JobApplicationRequest(Long companyId,
                                    String position,
                                    LocalDate applicationDate,
                                    ApplicationStatus status,
                                    String notes
) {

}
