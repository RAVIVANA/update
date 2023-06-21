package com.nkxgen.spring.jdbc.Dao;
import com.nkxgen.spring.jdbc.model.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AccountTypesDAO implements AccountTypeInterface{
	@PersistenceContext
	private EntityManager entityManager;

	public List<accountTypes> getAllAccounts() {
		String jpql = "SELECT l FROM accountTypes l";
		TypedQuery<accountTypes> query = entityManager.createQuery(jpql, accountTypes.class);
		return query.getResultList();
	}

	public List<accountTypes> getAllAccountDetails() {
		String jpql = "SELECT l FROM accountTypes l";
		TypedQuery<accountTypes> query = entityManager.createQuery(jpql, accountTypes.class);
		return query.getResultList();
	}

	public accountTypes getSelectedAccountDetails(int accountType) {
		accountTypes account = entityManager.find(accountTypes.class, accountType);
		System.out.println("im in the dao of account types");
		System.out.println(account.getAccountType());
		return account;
	}
	public void save(accountTypes accountTypes) {
		entityManager.merge(accountTypes);
	}

}
