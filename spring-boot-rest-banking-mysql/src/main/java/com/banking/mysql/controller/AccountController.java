package com.banking.mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.mysql.entity.Account;
import com.banking.mysql.service.AccountServiceImp;

//@Controller
@RestController
public class AccountController {

	@Autowired
	private AccountServiceImp service;

	@RequestMapping("/baseform")
	public String showBaseForm(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		return "index";
	}

//	@GetMapping("/")
//	public String baseAPi(Model model) {
//		return "index";
//	}

	@GetMapping("/listAccount")
	public List<Account> getAllAcc() {
		return service.getAllAccounts();
	}

	@GetMapping("/account/{id}")
	public Optional<Account> getAccountById(@PathVariable Long id) {
		System.out.println("inside:  /account/" + id);
		return service.getAccountById(id);
	}
//	
//	@PostMapping("/createaccount")
//	public Account createAccount(@RequestBody Account account) {
//		return service.createAccount(account);
//	}

	@PostMapping("/createaccount")
	public String createAccount(@ModelAttribute("account") Account account) {
		Account acc = service.createAccount(account);
		return "account-confirmation";
	}

}
