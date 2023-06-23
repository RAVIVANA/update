package com.nkxgen.spring.jdbc.model;

public class tempRepayment {
	private int loanid;
	private int emi;
	private double interest;
	private double total;
	private int amount;

	public tempRepayment() {

	}

	public int getLoanid() {
		return loanid;
	}

	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}

	public int getEMI() {
		return emi;
	}

	public void setEMI(int emi) {
		this.emi = emi;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterset(double interest) {
		this.interest = interest;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}