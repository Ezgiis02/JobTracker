package com.ezgi.jobtracker.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= false ,length=150)
    private String position;

    @Column(nullable= false)
    private LocalDate applicationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=20)
    private ApplicationStatus status;

    @Column (length=1000)
    private String notes;

    @ManyToOne
    @JoinColumn(name= "company_id",nullable= false)
    private Company company;

    protected JobApplication(){}

    public JobApplication(Company company,String position,LocalDate applicationDate,ApplicationStatus status,String notes){
        this.company=company;
        this.position=position;
        this.applicationDate=applicationDate;
        this.status=status;
        this.notes=notes;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }
}
