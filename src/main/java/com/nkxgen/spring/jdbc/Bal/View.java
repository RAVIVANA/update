package com.nkxgen.spring.jdbc.Bal;
import java.util.List;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import com.nkxgen.spring.jdbc.Dao.AccountApplicationDaoInterface;
import com.nkxgen.spring.jdbc.Dao.BankUserInterface;
import com.nkxgen.spring.jdbc.Dao.LoanApplicationDaoInterface;
import com.nkxgen.spring.jdbc.model.*;


public class View {
@Autowired
LoanApplicationDaoInterface ll;
@Autowired
AccountApplicationDaoInterface ac;
@Autowired
BankUserInterface bankUserService;



List<LoanAccountViewModel> viewlist=new ArrayList<>();
List<LoanApplicationViewModel> viewlist1=new ArrayList<>();
List<AccountViewModel> viewlist2=new ArrayList<>();
List<BankUserViewModel> viewlist3=new ArrayList<>();

public List<LoanAccountViewModel> set(String typee) {
	viewlist.clear();
	List<LoanAccount> list=ll.getLoanAccountsByLoanType(typee);
	for(LoanAccount l:list) {
		LoanAccountViewModel la=new LoanAccountViewModel();
		la.setValuesFromLoanAccount(l);
		viewlist.add(la);
	}
	return viewlist;
}
public List<LoanApplicationViewModel> set1(String typee) {
	viewlist1.clear();
	List<LoanApplication> list=ll.getLoanApplicationsByStatus(typee);
	for(LoanApplication l:list) {
		LoanApplicationViewModel la=new LoanApplicationViewModel();
		la.copyFromEntity(l);
		viewlist1.add(la);
	}
	return viewlist1;
}
public List<LoanApplicationViewModel> set6(String typee) {
	viewlist1.clear();
	List<LoanApplication> list=ll.findByValue(typee);
	for(LoanApplication l:list) {
		LoanApplicationViewModel la=new LoanApplicationViewModel();
		la.copyFromEntity(l);
		viewlist1.add(la);
	}
	return viewlist1;
}
public List<AccountViewModel> set2(String typee) {
	viewlist2.clear();
	List<Account> list=ac.getAccountsByType(typee);
	for(Account l:list) {
		AccountViewModel la=new AccountViewModel();
		la.mapToViewModel(l);
		viewlist2.add(la);
	}
	return viewlist2;
}
public List<BankUserViewModel> set3() {
	viewlist3.clear();
	List<BankUser> list=bankUserService.getAllBankUsers();
	for(BankUser l:list) {
		BankUserViewModel la=new BankUserViewModel();
		la.setFromEntity(l);
		viewlist3.add(la);
	}
	return viewlist3;
}
public List<BankUserViewModel> set4(BankUser status) {
	viewlist3.clear();
	List<BankUser> list=bankUserService.getBankUsersByDesignation(status);
	for(BankUser l:list) {
		BankUserViewModel la=new BankUserViewModel();
		la.setFromEntity(l);
		viewlist3.add(la);
	}
	return viewlist3;
}
public List<BankUserViewModel> set5(String status) {
	viewlist3.clear();
	List<BankUser> list=bankUserService.getBankUsersByDesignation(status);
	for(BankUser l:list) {
		BankUserViewModel la=new BankUserViewModel();
		la.setFromEntity(l);
		viewlist3.add(la);
	}
	return viewlist3;
}
}
