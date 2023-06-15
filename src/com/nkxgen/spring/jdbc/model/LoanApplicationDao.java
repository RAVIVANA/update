package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class LoanApplicationDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<LoanApplication> findByValue(String value) {
		String jpql = "SELECT la FROM LoanApplication la WHERE la.loanTypeId = :value and la.status=: val";
		TypedQuery<LoanApplication> query = entityManager.createQuery(jpql, LoanApplication.class);
		query.setParameter("value", value);
		query.setParameter("val", "waiting");

		return query.getResultList();
	}
}
