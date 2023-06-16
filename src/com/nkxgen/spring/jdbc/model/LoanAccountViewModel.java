package com.nkxgen.spring.jdbc.model;

import java.math.BigDecimal;

public class LoanAccountViewModel {

    private Long loanId;
    private String loanType;
    private Integer customerId;
    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private Integer loanDuration;

    // Constructors
    public LoanAccountViewModel() {
    }

    public LoanAccountViewModel(Long loanId, String loanType, Integer customerId, BigDecimal loanAmount,
            BigDecimal interestRate, Integer loanDuration) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.customerId = customerId;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanDuration = loanDuration;
    }

    // Setters
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void setLoanDuration(Integer loanDuration) {
        this.loanDuration = loanDuration;
    }

    // Getters
    public Long getLoanId() {
        return loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public Integer getLoanDuration() {
        return loanDuration;
    }
}
