package com.nkxgen.spring.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.jdbc.Bal.View;
import com.nkxgen.spring.jdbc.Bal.ViewInterface;
import com.nkxgen.spring.jdbc.Dao.AccountTypeInterface;
import com.nkxgen.spring.jdbc.Dao.LoanTypesInterface;
import com.nkxgen.spring.jdbc.model.AccountTypeInput;
import com.nkxgen.spring.jdbc.model.AccountTypeView;
import com.nkxgen.spring.jdbc.model.LoanTypeInput;
import com.nkxgen.spring.jdbc.model.LoanViewModel;
import com.nkxgen.spring.jdbc.model.LoansTypes;
import com.nkxgen.spring.jdbc.model.accountTypes;

@Controller
public class masterController {

	// @Autowired
	// private AccountRepository rs;
	@Autowired
	private AccountTypeInterface account;
	@Autowired
	ViewInterface v;
	// @Autowired
	// private LoansRepository rs;
	@Autowired
	private LoanTypesInterface loan;

	@RequestMapping(value = "/account_data_save", method = RequestMethod.POST)
	public String accountApplicationSave(AccountTypeInput accountTypes, Model model) {
		accountTypes at = new accountTypes();
		at.setInputModelValues(accountTypes);
		account.save(at);
		return "account_master_entry";
	}

	@RequestMapping(value = "/get_account_types", method = RequestMethod.GET)
	public String getAccounts(Model model) {
		List<AccountTypeView> list = v.set11();
		for (AccountTypeView ll : list) {
			System.out.println(ll.getAccountType());
		}
		model.addAttribute("accountTypes", list);
		return "getaccounts";
	}

	/*
	 * @RequestMapping(value = "/get_loan_details", method = RequestMethod.GET) public String getLoanDetails(Model
	 * model) { List<Loans> list = l.getAllLoanDetails(); for (Loans ll : list) {
	 * System.out.println(ll.getDescriptionForm()); } model.addAttribute("loans", list); return "loandetails"; }
	 */

	@RequestMapping(value = "/get_selected_account_details", method = RequestMethod.GET)
	public String getSelectedAccountDetails(@RequestParam("accountType") int accountType, Model model) {

		AccountTypeView accountT = v.set10(accountType);
		/*
		 * for (Loans ll : list) { System.out.println(ll.getDescriptionForm()); }
		 */
		System.out.println("the iid value is :" + accountT.getAccountType());
		System.out.println("the iid value is :" + accountT.getDescriptionForm());
		model.addAttribute("accounts", accountT);
		return "accountdetails";
	}
	// =============================================================================================

	@RequestMapping(value = "/loan_data_save", method = RequestMethod.POST)
	public String loanApplicationSave(LoanTypeInput loans, Model model) {
		LoansTypes lt = new LoansTypes();
		lt.setInputModelValues(loans);
		System.out.println("hello");
		loan.save(lt);
		return "loan_master_entry";
	}

	@RequestMapping(value = "/get_loan_types", method = RequestMethod.GET)
	public String getLoans(Model model) {
		List<LoanViewModel> list = v.set9();
		for (LoanViewModel ll : list) {
			System.out.println(ll.getLoanType());
		}
		model.addAttribute("loans", list);
		return "getloans";
	}

	/*
	 * @RequestMapping(value = "/get_loan_details", method = RequestMethod.GET) public String getLoanDetails(Model
	 * model) { List<Loans> list = l.getAllLoanDetails(); for (Loans ll : list) {
	 * System.out.println(ll.getDescriptionForm()); } model.addAttribute("loans", list); return "loandetails"; }
	 */

	@RequestMapping(value = "/get_selected_loan_details", method = RequestMethod.GET)
	public String getSelectedLoanDetails(@RequestParam("loanType") int loanType, Model model) {
		System.out.println("the value is" + loanType);
		// System.out.println("get selected loan controller");
		LoanViewModel loank = v.set8(loanType);
		/*
		 * for (Loans ll : list) { System.out.println(ll.getDescriptionForm()); }
		 */
		System.out.println("the iid value is :" + loank.getLoanId());
		model.addAttribute("loans", loank);
		return "loandetails";
	}

	// =================================================================================================================
	// @RequestMapping("/master_account")
	// public String masterAccount(Model model) {
	// return "account_master_entry";
	// }
	//
	@RequestMapping("/master_loan")
	public String masterloan(Model model) {
		return "loan_master_entry";
	}

}
