package com.nkxgen.spring.jdbc.controller;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.AccountApplication;
import com.nkxgen.spring.jdbc.Dao.AccountApplicationDaoInterface;
import com.nkxgen.spring.jdbc.model.Accountdocument;
import com.nkxgen.spring.jdbc.model.Customer;
import com.nkxgen.spring.jdbc.Dao.CustomerDaoInterface;
import com.nkxgen.spring.jdbc.model.Types;

@Controller
public class AccountController {
	@Autowired
	private AccountApplicationDaoInterface ac;
     AccountController(AccountApplicationDaoInterface ac){
    	 this.ac=ac;
     }
	@Autowired
	private CustomerDaoInterface cd;

	@RequestMapping("/master_account")
	public String masterAccount(Model model) {
		return "account_master_entry";
	}

	@RequestMapping(value = "/New_account_application", method = RequestMethod.POST)
	public String newAccountApplication(@Validated Types t, Model model) {
		String value = t.gethrefvalue();
		System.out.println("neeraj control mapping loki vachav " + value);
		List<AccountApplication> list1 = ac.getAccountsappByType(value);

		// Check if the list is not empty before accessing the first object
		if (!list1.isEmpty()) {
			AccountApplication firstAccount = list1.get(0);
			String acapActyId = firstAccount.getAcap_acty_id();
			System.out.println("acap_acty_id of first object: " + acapActyId);
		}

		model.addAttribute("list_of_account_applications", list1);
		return "New_account_application";
	}

	// =====================================================================================
	@RequestMapping(value = "/Any_Type_account_info", method = RequestMethod.POST)
	public String view_accounts(@Validated Types t, Model model) {
		System.out.println("lopaliki vachav");
		String value = t.gethrefvalue();
		List<Account> list1 = ac.getAccountsByType(value);
		List<Customer> list2 = new ArrayList<>();
		for (Account account : list1) {
			Customer customer = cd.getRealCustomerById(account.getCustomerId());
			System.out.println(customer.getCust_dob());
			list2.add(customer);
		}
		model.addAttribute("list_of_account", list1);
		model.addAttribute("list_of_customer", list2);
		return "Any_Type_account_info";
	}

	// ===============================================================================================
	@RequestMapping("/result")
	public String ne(Model model) {
		return "New_account_application";
	}

	// ===========================================================================================
	@RequestMapping("/Account_new_application_form")
	public String accountNewApplicationForm(Model model) {
		return "Account_new_application_form";
	}

	// ===========================================================================================
	@RequestMapping("/Any_Type_account_info")
	public String anyTypeAccountInfo(Model model) {
		return "Any_Type_account_info";
	}
	// ===========================================================================================

	@RequestMapping(value = "/account_application_save", method = RequestMethod.POST)
	public String accountApplicationSave(@Validated AccountApplication accountApplication, Model model) {
		System.out.println("hello");
		ac.save(accountApplication);
		return "Account_new_application_form";
	}
	// ===========================================================================================
	
	// ===================================================================================================
	@RequestMapping(value = "/save_to_account_database", method = RequestMethod.POST)
	public String save_to_account_database(@Validated Account account, Model model) {
		ac.save1(account);
		// change the return
		return "Account_new_application_form";
	}

	@RequestMapping(value = "/save_to_account_documents_database", method = RequestMethod.POST)
	public String save_to_account_documents_database(@Validated Accountdocument accountdocument, Model model) {
		ac.save2(accountdocument);
		// change the return
		return "Account_new_application_form";
	}
	// // ======================================================================================================

}
