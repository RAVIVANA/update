package com.nkxgen.spring.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanAccountDao;
import com.nkxgen.spring.jdbc.model.LoanApplication;
import com.nkxgen.spring.jdbc.model.LoanApplicationDao;
import com.nkxgen.spring.jdbc.model.LoanApplicationDaoImpl;
import com.nkxgen.spring.jdbc.model.LoanApplicationDaos;
import com.nkxgen.spring.jdbc.model.LoanApplications;
import com.nkxgen.spring.jdbc.model.Types;

@Controller
public class neerajController {

	@RequestMapping(value = "/master_loan", method = RequestMethod.GET)
	public String master_loan(Model model) {

		return "loan_master_entry";

	}

	@RequestMapping(value = "/permission_management", method = RequestMethod.GET)
	public String permission_management(Model model) {

		return "Permission_management";

	}

	@Autowired
	LoanApplicationDaoImpl ll;
	@Autowired
	LoanApplicationDao l1;
	@Autowired
	LoanApplicationDaos l2;
	@Autowired
	LoanAccountDao l3;

	@RequestMapping(value = "/loan_new_application_form", method = RequestMethod.GET)
	public String loan_new_application_form(Model model) {
		return "loan_new_application_form";
	}

	@RequestMapping(value = "/edit_form", method = RequestMethod.GET)
	public String edit_form(Model model) {
		return "edit_form";
	}

	@RequestMapping(value = "/redirected", method = RequestMethod.GET)
	public String redirect_form(Model model) {
		List<LoanApplication> l = l2.getLoanApplicationsByStatus("redirected");
		model.addAttribute("loanApplications", l);
		return "Application1";
	}

	@RequestMapping(value = "/New_loan_Application", method = RequestMethod.POST)
	public String New_loan_application(@Validated LoanApplication l, Model model) {

		ll.saveLoanApplication(l);
		return "loan_new_application_form";
	}

	@RequestMapping(value = "/update_application", method = RequestMethod.POST)
	public String updateLoanApplication(@Validated LoanApplications loanApplication) {
		ll.updateLoanApplication(loanApplication);
		return "Application";

	}

	@RequestMapping(value = "/get_applications", method = RequestMethod.POST)
	public String Get_loan_application(@Validated Types l, Model model) {

		List<LoanApplication> list = l1.findByValue(l.getValue());
		model.addAttribute("loanApplications", list);
		return "Application";

	}

	@RequestMapping(value = "/Account", method = RequestMethod.POST)
	public String Get_loan_accounts(@Validated Types l, Model model) {
		List<LoanAccount> list = l3.getLoanAccountsByLoanType(l.getValue());
		model.addAttribute("loanAccounts", list);
		return "Application3";

	}
}
