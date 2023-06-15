package com.nkxgen.spring.jdbc.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accountdocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_nominee_first_name")
    private String nomineeFirstName;

    @Column(name = "application_nominee_last_name")
    private String nomineeLastName;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "application_date")
    private String applicationDate;

    @Column(name = "account_type_id")
    private String accountTypeId;

    @Column(name = "processed_by")
    private String createdBy;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "aadhar_card")
    private String aadharCard;

    @Column(name = "pan_card")
    private String panCard;

    @Column(name = "passport")
    private String passport;

    @Column(name = "driving_license")
    private String drivingLicense;

    @Column(name = "job_card")
    private String jobCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomineeFirstName() {
        return nomineeFirstName;
    }

    public void setNomineeFirstName(String nomineeFirstName) {
        this.nomineeFirstName = nomineeFirstName;
    }

    public String getNomineeLastName() {
        return nomineeLastName;
    }

    public void setNomineeLastName(String nomineeLastName) {
        this.nomineeLastName = nomineeLastName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getJobCard() {
        return jobCard;
    }

    public void setJobCard(String jobCard) {
        this.jobCard = jobCard;
    }
}
