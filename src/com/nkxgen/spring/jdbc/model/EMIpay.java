package com.nkxgen.spring.jdbc.model;



public class EMIpay {
	private long loanid;
	private String accountHolder;
	private String loanType;
	private long loanamount;
	private int NOI;
	private double interestRate;
	private int loan_pending;
	private int remainMonths;
	private int emi;
	private long interest;
	private double total;
	private int pastdue;
	private double complete;

	public EMIpay() {

	}

	public long getLoanId() {
		return loanid;
	}

	public void setLoanId(long loanid) {
		this.loanid = loanid;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public long getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(long loanamount) {
		this.loanamount = loanamount;
	}

	public int getNOI() {
		return NOI;
	}

	public void setNOI(int NOI) {
		this.NOI = NOI;
	}

	public int getLoan_pending() {
		return loan_pending;
	}

	public void setLoan_pending(int loan_pending) {
		this.loan_pending = loan_pending;
	}

	public int getRemainMonths() {
		return remainMonths;
	}

	public void setRemainMonths(int remainMonths) {
		this.remainMonths = remainMonths;
	}

	public int getEmi() {
		return emi;
	}

	public void setEmi(int emi) {
		this.emi = emi;
	}

	public long getInterest() {
		return interest;
	}

	public void setInterest(long interest) {
		this.interest = interest;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getPastDue() {
		return pastdue;
	}

	public void setPastDue(int pastdue) {
		this.pastdue = pastdue;
	}

	public double getComplete() {
		return complete;
	}

	public void setComplete(double complete) {
		this.complete = complete;
	}
}