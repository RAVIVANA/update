package com.nkxgen.spring.jdbc.Dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.nkxgen.spring.jdbc.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountApplicationDAO implements AccountApplicationDaoInterface {
	AccountApplicationDAO() {

	}

	@PersistenceContext
	private EntityManager entityManager;

	public void save(AccountApplication accountApplication) {
		entityManager.persist(accountApplication);
	}

	public List<AccountApplication> getAccountsappByType(String value) {
		System.out.println("neeraj function loki vacahav repository lo : " + value);

		String jpql = "SELECT la FROM AccountApplication la WHERE la.acap_acty_id = :value";
		TypedQuery<AccountApplication> query = entityManager.createQuery(jpql, AccountApplication.class);
		query.setParameter("value", value);

		List<AccountApplication> list1 = query.getResultList();

		if (!list1.isEmpty()) {
			AccountApplication firstAccount = list1.get(0);
			String acapActyId = firstAccount.getAcap_acty_id();
			System.out.println("acap_acty_id of first object: " + acapActyId);
		}

		return list1;
	}

	public List<Account> getAccountsByType(String acnt_acty_id) {
		String jpql = "SELECT la FROM Account la WHERE la.accountTypeId = :acnt_acty_id";
		TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);
		query.setParameter("acnt_acty_id", acnt_acty_id);
		return query.getResultList();
	}

	public void save1(Account account) {
		Account mergedAccount = entityManager.merge(account);
		entityManager.persist(mergedAccount);

	}

	public void save2(Accountdocument accountdocument) {
		Accountdocument mergedAccount = entityManager.merge(accountdocument);
		entityManager.persist(mergedAccount);

	}

	// public String gettheid(String inputValue) {
	// String jpql = "SELECT e.id FROM AccountType e WHERE e.value = :inputValue";
	// TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
	// query.setParameter("inputValue", inputValue);
	// return query.getSingleResult();
	// }
}
