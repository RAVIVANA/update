package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accountApplicationsTable")
public class AccountApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acap_id")
	private Long acapId;

	@Column(name = "acap_cust_id")
	private Long customerId;

	@Column(name = "acap_nominee_fn")
	private String acapNomineeFirstName;

	@Column(name = "acap_nominee_ln")
	private String acapNomineeLastName;

	@Column(name = "acap_acty_id")
	private String acap_acty_id;

	@Column(name = "acap_createdby")
	private String createdBy;

	@Column(name = "acap_apdate")
	private String applicationDate;

	@Column(name = "acap_createddate")
	private String createdDate;

	@Column(name = "acap_processedby")
	private String processedBy;

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

	public Long getCustomerId() {
		return customerId;
	}

	public String getAcapNomineeFirstName() {
		return acapNomineeFirstName;
	}

	public String getAcapNomineeLastName() {
		return acapNomineeLastName;
	}

	public String getAcap_acty_id() {
		return acap_acty_id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public String getProcessedBy() {
		return processedBy;
	}

	public String getAadhar() {
		return aadhar;
	}

	public String getPan() {
		return pan;
	}

	public String getPassport() {
		return passport;
	}

	public String getDriving() {
		return driving;
	}

	public String getJobcard() {
		return jobcard;
	}

	public void setAcapId(Long acapId) {
		this.acapId = acapId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setAcapNomineeFirstName(String acapNomineeFirstName) {
		this.acapNomineeFirstName = acapNomineeFirstName;
	}

	public void setAcapNomineeLastName(String acapNomineeLastName) {
		this.acapNomineeLastName = acapNomineeLastName;
	}

	public void setAcap_acty_id(String acap_acty_id) {
		this.acap_acty_id = acap_acty_id;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public void setProcessedBy(String processedBy) {
		this.processedBy = processedBy;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public void setDriving(String driving) {
		this.driving = driving;
	}

	public void setJobcard(String jobcard) {
		this.jobcard = jobcard;
	}
}