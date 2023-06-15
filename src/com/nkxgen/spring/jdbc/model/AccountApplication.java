package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "your_table_name2")
public class AccountApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acap_id")
	private Long acapId;

	@Column(name = "acap_nominee_fn")
	private String acapNomineeFirstName;

	@Column(name = "acap_nominee_ln")
	private String acapNomineeLastName;

	@Column(name = "acap_cust_id")
	private Long customerId;

	@Column(name = "acap_apdate")
	private String applicationDate;

	@Column(name = "acap_acty_id")
	private Integer accountTypeId;

	@Column(name = "acap_createdby")
	private String createdBy;

	@Column(name = "acap_createddate")
	private String createdDate;

	@Column(name = "aadhar")
	private String aadhar;

	@Column(name = "pan")
	private String pan;

	@Column(name = "passport")
	private String passport;

	@Column(name = "driving")
	private String driving;

	@Column(name = "jobcard")
	private String jobcard;

	public Long getAcapId() {
		return acapId;
	}

	public void setAcapId(Long acapId) {
		this.acapId = acapId;
	}

	public String getAcapNomineeFirstName() {
		return acapNomineeFirstName;
	}

	public void setAcapNomineeFirstName(String acapNomineeFirstName) {
		this.acapNomineeFirstName = acapNomineeFirstName;
	}

	public String getAcapNomineeLastName() {
		return acapNomineeLastName;
	}

	public void setAcapNomineeLastName(String acapNomineeLastName) {
		this.acapNomineeLastName = acapNomineeLastName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Integer getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Integer accountTypeId) {
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

	public String getAadhar() {
		return aadhar;
	}

	public void setaadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setpan(String pan) {
		this.pan = pan;
	}

	public String getPassport() {
		return passport;
	}

	public void setpassport(String passport) {
		this.passport = passport;
	}

	public String getDriving() {
		return driving;
	}

	public void setdriving(String driving) {
		this.driving = driving;
	}

	public String getJobcard() {
		return jobcard;
	}

	public void setjobcard(String jobcard) {
		this.jobcard = jobcard;
	}

}
