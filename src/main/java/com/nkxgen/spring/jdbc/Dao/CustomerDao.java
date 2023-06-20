package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nkxgen.spring.jdbc.model.Customer;
import com.nkxgen.spring.jdbc.model.CustomerSub;
import com.nkxgen.spring.jdbc.model.Customertrail;
import com.nkxgen.spring.jdbc.model.service;

@Repository
@Transactional
public class CustomerDao implements CustomerDaoInterface {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save_Trail(Customertrail customer) {
		entityManager.merge(customer);

	}

	public void save_trail(Customertrail customer) {
		entityManager.persist(customer);
	}

	public Customertrail getCustomerById(Long id) {
		// Retrieve customer data from the table based on the ID
		Customertrail customer = entityManager.find(Customertrail.class, id);
		return customer;
	}

	public void save(Customer customer) {
		entityManager.persist(customer);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		String jpql = "SELECT la FROM Customer la";
		TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
		return query.getResultList();
	}

	public void updateCustomerDataById(Customer updatedCustomer) {

		entityManager.merge(updatedCustomer);

	}

	public void deleteCusById(Customertrail cus) {
		// TODO Auto-generated method stub
		// Assuming Customertrail class has an 'id' property

		long customerId = cus.getId();

		Customertrail customer = entityManager.find(Customertrail.class, customerId);

		if (customer != null) {
			entityManager.remove(customer);
			System.out.println("Customer with ID " + customerId + " has been deleted successfully.");
		} else {
			System.out.println("Customer with ID " + customerId + " does not exist.");
		}
	}

	public Customertrail getRealCustomerById(Long customerId) {
		Customertrail customer = entityManager.find(Customertrail.class, customerId);
		return customer;
	}

	@Override
	public void changethese(Customertrail customer2, CustomerSub customerSub) {
		Customertrail customer = service.changing(customer2, customerSub);
		entityManager.merge(customer);

	}

}