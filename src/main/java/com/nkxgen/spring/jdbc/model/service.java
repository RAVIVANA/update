package com.nkxgen.spring.jdbc.model;

public class service {

	public static Customer dotheservice(Customertrail customertrail) {
		Customer customer = new Customer();
		customer.setCust_id(customertrail.getId());
		customer.setCust_title(customertrail.getTitle());
		customer.setCust_type(customertrail.getType());
		customer.setCust_caddress(customertrail.getCurrentAddress());
		customer.setCust_capincode(customertrail.getCurrentPINCode());
		customer.setCust_dob(customertrail.getDateOfBirth());
		customer.setCust_mobile1(customertrail.getMobile1());
		customer.setCust_mobile2(customertrail.getMobile2());
		customer.setCust_rphone(customertrail.getResidencePhone());
		customer.setCust_raddress(customertrail.getResidenceAddress());

		return customer;
	}

	public static Customer changing(Customer customer2, CustomerSub customerSub) {
		customer2.setCust_title(customerSub.getTitle());
		customer2.setCust_mobile1(customerSub.getPhoneNo());
		customer2.setCust_raddress(customerSub.getAddress());
		return customer2;
	}

}
