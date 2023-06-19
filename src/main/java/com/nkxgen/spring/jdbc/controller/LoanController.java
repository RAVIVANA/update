package com.nkxgen.spring.jdbc.controller;

import java.util.List;

import com.nkxgen.spring.jdbc.Bal.View;
import com.nkxgen.spring.jdbc.Dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanAccountViewModel;
import com.nkxgen.spring.jdbc.model.LoanApplication;
import com.nkxgen.spring.jdbc.model.LoanApplicationViewModel;
import com.nkxgen.spring.jdbc.model.LoanApplications;
import com.nkxgen.spring.jdbc.model.Types;

@Controller
public class LoanController {

	@Autowired
	LoanApplicationDaoInterface ll;
	@Autowired
	CustomerDaoInterface cd;
	@Autowired
	View v;

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
		List<LoanApplicationViewModel> list = v.set1("redirecting");
		model.addAttribute("loanApplications", list);
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

		List<LoanApplicationViewModel> list = v.set6(l.gethrefvalue());
		model.addAttribute("loanApplications", list);
		return "Application";

	}

	@RequestMapping(value = "/Account", method = RequestMethod.POST)
	public String Get_loan_accounts(@Validated Types l, Model model) {
		List<LoanAccountViewModel> list =v.set(l.gethrefvalue());

		model.addAttribute("loanAccounts", list);
		return "Application3";

	}
}
