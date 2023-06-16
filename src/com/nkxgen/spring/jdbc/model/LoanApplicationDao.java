package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LoanApplicationDao implements LoanApplicationDaoInterface {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<LoanApplication> findByValue(String value) {
		String jpql = "SELECT la FROM LoanApplication la WHERE la.loanTypeId = :value and la.status=: val";
		TypedQuery<LoanApplication> query = entityManager.createQuery(jpql, LoanApplication.class);
		query.setParameter("value", value);
		query.setParameter("val", "waiting");

		return query.getResultList();
	}

	@Override
	public void saveLoanApplication(LoanApplication loanApplication) {
		entityManager.persist(loanApplication);
	}

	@Override
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

	@Override
	public List<LoanApplication> getLoanApplicationsByStatus(String status) {
		String jpql = "SELECT la FROM LoanApplication la WHERE la.status = :status";
		TypedQuery<LoanApplication> query = entityManager.createQuery(jpql, LoanApplication.class);
		query.setParameter("status", status);
		return query.getResultList();
	}

	@Override
	public List<LoanAccount> getLoanAccountsByLoanType(String loanType) {
		String queryStr = "SELECT la FROM LoanAccount la WHERE la.loanType = :loanType";
		TypedQuery<LoanAccount> query = entityManager.createQuery(queryStr, LoanAccount.class);
		query.setParameter("loanType", loanType);
		return query.getResultList();
	}
}
