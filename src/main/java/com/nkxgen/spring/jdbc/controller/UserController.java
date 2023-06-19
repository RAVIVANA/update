package com.nkxgen.spring.jdbc.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nkxgen.spring.jdbc.model.BankUser;
import com.nkxgen.spring.jdbc.model.BankUserViewModel;
import com.nkxgen.spring.jdbc.Bal.View;
import com.nkxgen.spring.jdbc.Dao.*;

@Controller
public class UserController {

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser() {
		return "addUser";
	}
	@Autowired
	View v;
	private final BankUserInterface bankUserService;

	@Autowired
	public UserController(BankUserInterface bankUserService) {
		this.bankUserService = bankUserService;
	}

	@RequestMapping(value = "/submit_form", method = RequestMethod.POST)
	public ResponseEntity<String> submitForm(BankUser bankUser, Model model) {
		System.out.println(bankUser);
		bankUserService.saveBankUser(bankUser);
		return ResponseEntity.ok("Data saved successfully!");
	}

	@RequestMapping(value = "/mainUser", method = RequestMethod.GET)
	public String getBankUsers(Model model) {
		List<BankUserViewModel> bankUsers = v.set3();
		model.addAttribute("bankUsers", bankUsers);
		return "mainUser";
	}

	@RequestMapping(value = "/get_list", method = RequestMethod.GET)
	public String listUsers(Model model) {

		return "dropdown";
	}

	@RequestMapping(value = "/get_bank_user", method = RequestMethod.POST)
	public String listUsers(@RequestParam("busr_desg") String busrDesg, Model model) {

		List<BankUserViewModel> b = v.set5(busrDesg);
		model.addAttribute("bankUser", b);
		return "Usertables";
	}

	@RequestMapping("/saveUserData")
	@ResponseBody
	public String saveUserData(@ModelAttribute("BankUser") BankUser bankUser) {
		System.out.println(bankUser);
		bankUserService.saveUser(bankUser);
		return "User data saved successfully";
	}

	@RequestMapping(value = "/fetchData", method = RequestMethod.POST)
	public String fetchData(@ModelAttribute("BankUser") BankUser bankUser, Model model) {
		List<BankUserViewModel> bankUsers;
		if (bankUser.getBusr_desg().equals("All")) {
			bankUsers = v.set3();
		} else {
			bankUsers = v.set4(bankUser);
		}
		model.addAttribute("bankUsers", bankUsers);
		return "bankUsers"; // Return the name of the HTML page as the view
	}

}
