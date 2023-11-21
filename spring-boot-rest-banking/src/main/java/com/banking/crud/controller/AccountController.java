package com.banking.crud.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.crud.entity.Account;
import com.banking.crud.service.AccountServiceImp;

@RestController
public class AccountController {

	@Autowired
	private AccountServiceImp accountService;

	@PostMapping("/createAccount")
	public Account createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}

	@GetMapping("/findAllAccounts")
	public List<Account> findAllAccounts() {
		return accountService.findAllAccounts();
	}

	@GetMapping("/account/{accountNumber}")
	public Account getAccount(@PathVariable Long accountNumber) {
		return accountService.getAccountByAccountNumber(accountNumber);
	}

	@DeleteMapping("/account/{accountNumber}")
	public String deleteAccount(@PathVariable Long accountNumber) {
		Account acc = accountService.getAccountByAccountNumber(accountNumber);
		return accountService.deleteAccount(acc);
	}

	@PutMapping("/updateAccount/{accNumber}")
	public Account updateAccount(@RequestBody Account account, @PathVariable Long accNumber) {
//		long accountNumber = account.getAccountNumber();
		return accountService.updateAccount(accNumber, account);

	}

}
