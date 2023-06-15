package com.nkxgen.spring.jdbc.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomerDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void save_trail(Customertrail customer) {
		entityManager.persist(customer);
	}

	public Customer getCustomerById(Long id) {
		// Retrieve customer data from the table based on the ID
		Customer customer = entityManager.find(Customer.class, id);
		return customer;
	}

	public void save(Customer customer) {
		entityManager.persist(customer);
	}

}
