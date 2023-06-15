package com.nkxgen.spring.jdbc.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LoanApplicationDaoImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public void saveLoanApplication(LoanApplication loanApplication) {
		entityManager.persist(loanApplication);
	}

	public void updateLoanApplication(LoanApplications loanApplication) {
		String updateQuery = "UPDATE LoanApplication l SET l.amount = :amount, l.emiLimitFrom = :emiLimitFrom, l.emiLimitTo = :emiLimitTo, l.tenureRequested = :tenureRequested, l.nominee = :nominee, l.createdBy = :createdBy, l.createdDate = :createdDate, l.processedBy = :processedBy, l.processDate = :processDate, l.processedStatus = :processedStatus, l.lastUpdatedDate = :lastUpdatedDate, l.lastUpdatedUser = :lastUpdatedUser, l.status = :status, l.remarks = :remarks, l.Attachment = :attachment WHERE l.customerId = :customerId";

		entityManager.createQuery(updateQuery).setParameter("amount", loanApplication.getAmount())
				.setParameter("emiLimitFrom", loanApplication.getEmiLimitFrom())
				.setParameter("emiLimitTo", loanApplication.getEmiLimitTo())
				.setParameter("tenureRequested", loanApplication.getTenureRequested())
				.setParameter("nominee", loanApplication.getNominee())
				.setParameter("createdBy", loanApplication.getCreatedBy())
				.setParameter("createdDate", loanApplication.getCreatedDate())
				.setParameter("processedBy", loanApplication.getProcessedBy())
				.setParameter("processDate", loanApplication.getProcessDate())
				.setParameter("processedStatus", loanApplication.getProcessedStatus())
				.setParameter("lastUpdatedDate", loanApplication.getLastUpdatedDate())
				.setParameter("lastUpdatedUser", loanApplication.getLastUpdatedUser())
				.setParameter("status", loanApplication.getStatus())
				.setParameter("remarks", loanApplication.getRemarks())
				.setParameter("attachment", loanApplication.getAttachment())
				.setParameter("customerId", loanApplication.getCustId()).executeUpdate();
	}
}
