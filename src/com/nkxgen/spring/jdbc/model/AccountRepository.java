package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Account> getAccountsByType(String accountType) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
		Root<Account> root = criteriaQuery.from(Account.class);

		Path<String> typePath = root.get("type"); // Assuming "type" is the attribute name in the Account entity

		Predicate condition = criteriaBuilder.equal(typePath, accountType);
		criteriaQuery.where(condition);

		TypedQuery<Account> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

}
