package com.ezgi.jobtracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name="companies")
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length=100)
    private String name;

    private String city;
    private String website;

    protected Company(){}

    public Company(String name,String city,String website){
        this.name=name;
        this.city=city;
        this.website=website;
    }

    public String getName(){
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name){

        this.name=name;
    }
}
