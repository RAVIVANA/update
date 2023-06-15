package com.nkxgen.spring.jdbc.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BankUserDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public BankUser getBankUserById(int busr_id) {
		return entityManager.find(BankUser.class, busr_id);
	}
}
