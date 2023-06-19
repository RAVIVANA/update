package com.nkxgen.spring.jdbc.Dao;

import java.util.List;
import com.nkxgen.spring.jdbc.model.*;

public interface LoanApplicationDaoInterface {
	void saveLoanApplication(LoanApplication loanApplication);

	void updateLoanApplication(LoanApplications loanApplication);

	List<LoanApplication> findByValue(String value);

	List<LoanApplication> getLoanApplicationsByStatus(String status);

	List<LoanAccount> getLoanAccountsByLoanType(String loanType);

}
