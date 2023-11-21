package com.banking.mysql.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.mysql.entity.Account;
import com.banking.mysql.entity.Transaction;
import com.banking.mysql.service.AccountServiceImp;
import com.banking.mysql.service.TransactionServiceImp;

//@Controller
@RestController
public class TransactionController {

	@Autowired
	private TransactionServiceImp service;
	
	@Autowired
	private AccountServiceImp accountService;
	
	
	@PostMapping("/createTransaction")
	public Transaction createTrans(@RequestBody Transaction trans){
	
		return service.createTransaction(trans);
	}
	
	@RequestMapping("/init-transaction")
	public String showBaseTransaction(Model model) {
		Transaction transaction = new Transaction();
		model.addAttribute("transaction", transaction);
		return "init-transaction";
	}
	
//	@PostMapping("/createtransaction")
//	public String createTrans(@ModelAttribute Transaction transaction){
//			Transaction trans = service.createTransaction(transaction);
//			
//			return "transaction-confirmation";
//		}
}
