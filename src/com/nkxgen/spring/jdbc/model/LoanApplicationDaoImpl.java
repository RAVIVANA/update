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
}