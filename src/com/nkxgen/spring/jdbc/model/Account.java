package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AccountsTable")
public class Account {
	@Id
	@Column(name = "application_id")
	private Long applicationId;

	@Column(name = "account_type_id")
	private String accountTypeId;

	@Column(name = "nominee_first_name")
	private String applicationNomineeFirstName;

	@Column(name = "nominee_last_name")
	private String applicationNomineeLastName;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "Created_date")
	private String CreatedDate;

	@Column(name = "Created_by")
	private String CreatedBy;

	@Column(name = "processed_by")
	private String processedBy;

	// Getters and setters

	public Long getApplicationId() {
		return applicationId;
	}

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public String getApplicationNomineeFirstName() {
		return applicationNomineeFirstName;
	}

	public String getApplicationNomineeLastName() {
		return applicationNomineeLastName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getCreated_date() {
		return CreatedDate;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public String getProcessedBy() {
		return processedBy;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public void setApplicationNomineeFirstName(String applicationNomineeFirstName) {
		this.applicationNomineeFirstName = applicationNomineeFirstName;
	}

	public void setApplicationNomineeLastName(String applicationNomineeLastName) {
		this.applicationNomineeLastName = applicationNomineeLastName;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCreatedDate(String CreatedDate) {
		this.CreatedDate = CreatedDate;
	}

	public void setCreatedBy(String CreatedBy) {
		this.CreatedBy = CreatedBy;
	}

	public void setProcessedBy(String processedBy) {
		this.processedBy = processedBy;
	}
}
