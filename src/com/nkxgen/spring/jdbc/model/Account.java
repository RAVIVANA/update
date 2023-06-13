package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acnt_id")
    private Long accountId;
    
    @Column(name = "acnt_acty_id")
    private Long accountActivityId;
    
    @Column(name = "acnt_acap_id")
    private Long accountApplicationId;
    
    @Column(name = "acnt_cust_id")
    private Long customerId;
    
    @Column(name = "acnt_cdate")
    private Date createdDate;
    
    @Column(name = "acnt_processedy")
    private boolean processed;
    
    @Column(name = "account_nominee")
    private String nominee;
    
    @Column(name = "contact_no")
    private String contactNumber;
    
    @Column(name = "address")
    private String address;
    
    public Account() {
        // Default constructor
    }

    // Getters and Setters
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountActivityId() {
        return accountActivityId;
    }

    public void setAccountActivityId(Long accountActivityId) {
        this.accountActivityId = accountActivityId;
    }

    public Long getAccountApplicationId() {
        return accountApplicationId;
    }

    public void setAccountApplicationId(Long accountApplicationId) {
        this.accountApplicationId = accountApplicationId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
