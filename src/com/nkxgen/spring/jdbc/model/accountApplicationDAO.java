package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class accountApplicationDAO {
	accountApplicationDAO() {

	}

	@PersistenceContext
	private EntityManager entityManager;

	public void save(AccountApplication accountApplication) {
		entityManager.persist(accountApplication);
	}

	public List<AccountApplication> getAccountsappByType(String acap_acty_id) {
		String jpql = "SELECT la FROM LoanAccount la WHERE la.loanType = :acap_acty_id";
		TypedQuery<AccountApplication> query = entityManager.createQuery(jpql, AccountApplication.class);
		query.setParameter("acap_acty_id", acap_acty_id);
		return query.getResultList();
	}

	public List<Account> getAccountsByType(String acnt_acty_id) {
		String jpql = "SELECT la FROM LoanAccount la WHERE la.loanType = :acty_id";
		TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);
		query.setParameter("acnt_acty_id", acnt_acty_id);
		return query.getResultList();
	}

	public void save1(Account account) {
		entityManager.persist(account);

	}
}
