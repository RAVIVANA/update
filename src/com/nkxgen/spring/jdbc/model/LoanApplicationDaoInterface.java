package com.nkxgen.spring.jdbc.model;

import java.util.List;

public interface LoanApplicationDaoInterface {
	void saveLoanApplication(LoanApplication loanApplication);

	void updateLoanApplication(LoanApplications loanApplication);

	List<LoanApplication> findByValue(String value);

	List<LoanApplication> getLoanApplicationsByStatus(String status);

	List<LoanAccount> getLoanAccountsByLoanType(String loanType);

}
