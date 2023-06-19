package com.nkxgen.spring.jdbc.model;

public class AccountViewModel {
    private Long applicationId;
    private String accountTypeId;
    private String applicationNomineeFirstName;
    private String applicationNomineeLastName;
    private Long customerId;
    private String createdDate;
    private String createdBy;
    private String processedBy;

    // Getters and setters

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getApplicationNomineeFirstName() {
        return applicationNomineeFirstName;
    }

    public void setApplicationNomineeFirstName(String applicationNomineeFirstName) {
        this.applicationNomineeFirstName = applicationNomineeFirstName;
    }

    public String getApplicationNomineeLastName() {
        return applicationNomineeLastName;
    }

    public void setApplicationNomineeLastName(String applicationNomineeLastName) {
        this.applicationNomineeLastName = applicationNomineeLastName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }



    public void mapToViewModel(Account account) {
        AccountViewModel viewModel = new AccountViewModel();
        viewModel.setApplicationId(account.getApplicationId());
        viewModel.setAccountTypeId(account.getAccountTypeId());
        viewModel.setApplicationNomineeFirstName(account.getApplicationNomineeFirstName());
        viewModel.setApplicationNomineeLastName(account.getApplicationNomineeLastName());
        viewModel.setCustomerId(account.getCustomerId());
        viewModel.setCreatedDate(account.getCreated_date());
        viewModel.setCreatedBy(account.getCreatedBy());
        viewModel.setProcessedBy(account.getProcessedBy());
        
    }
}
