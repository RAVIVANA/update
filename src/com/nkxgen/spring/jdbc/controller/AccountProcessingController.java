package com.nkxgen.spring.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nkxgen.spring.jdbc.Bal.FDIntrestcaluclation;
import com.nkxgen.spring.jdbc.Bal.View;
import com.nkxgen.spring.jdbc.Dao.AccountApplicationDaoInterface;
import com.nkxgen.spring.jdbc.Dao.AccountProcessingDAO;
import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.InterestCal;

@Controller
public class AccountProcessingController {
	@Autowired
	private AccountApplicationDaoInterface ac;
	@Autowired
	private View v;
	@Autowired
	private FDIntrestcaluclation ac1;

	@RequestMapping(value = "/intrest", method = RequestMethod.GET)
	public String calculateInterest(Model model) {
		List<Account> list = ac.getall();
		List<Account> list1 = ac1.calcIntrst(list);
		for (Account aa : list1) {
			ac.mergeAccount(aa);
		}
		List<Account> list3 = ac.getall();
		model.addAttribute("accounts", list3);
		return "New2";
	}

	@RequestMapping(value = "/get_savings_accounts", method = RequestMethod.GET)
	public String get_intrest(Model model) {
		return "Accounttypes";
	}

	@RequestMapping(value = "/get_accounts", method = RequestMethod.GET)
	public String getAccounts(@RequestParam("accountType") String accountType, Model model) {
		List<Account> l = ac.getAccountssByType(accountType);
		List<Account> l1 = v.checkdate(l);
		model.addAttribute("accounts", l1);
		return "New2";
	}

	@RequestMapping(value = "/caluclate_intrest", method = RequestMethod.GET)
	public String clauclate(@RequestParam("accountType") String accountType, Model model) {
		List<Account> l = ac.getAccountssByType(accountType);
		List<Account> l1 = v.checkdate(l);
		List<Account> list1 = ac1.calcIntrst(l1);
		for (Account aa : list1) {
			ac.mergeAccount(aa);
		}
		List<Account> list3 = ac.getall();
		model.addAttribute("accounts", list3);
		return "New2";
	}

	@RequestMapping(value = "/statement", method = RequestMethod.GET)
	public String generateStatement(@PathVariable int accountId) {
		// Generate a statement for the specific account
		// Implementation logic goes here
		String statement = "Statement for Account " + accountId;
		// Generate the statement contents
		// ...
		return statement;
	}

	@Autowired
	private AccountProcessingDAO interestCalDao;

	@GetMapping("interesturl")
	public String calculate() {
		return "interest";
	}

	@PostMapping("/calculate")
	@ResponseBody
	public ResponseEntity<String> calculateInterest(@RequestParam("acctype") String acctype, Model model) {
		List<InterestCal> interestCalList = interestCalDao.getSavAcc(acctype);
		model.addAttribute("interestCal", interestCalList);
		System.out.println(interestCalList);
		return ResponseEntity.ok(" updated successfully");
	}
}