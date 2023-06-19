package com.nkxgen.spring.jdbc.Dao;
import  com.nkxgen.spring.jdbc.model.*;

import java.util.List;

public interface CustomerDaoInterface {

	void save_Trail(Customertrail customer);

	Customertrail getCustomerById(Long id);

	void save(Customer customer);

	List<Customer> getAllCustomers();

	void updateCustomerDataById(Customer updatedCustomer);

	void deleteCusById(Customertrail cus);

	Customer getRealCustomerById(Long id);

	void changethese(Customer customer2, CustomerSub customerSub);

}
