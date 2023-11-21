package com.banking.crud.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.banking.crud.entity.Account;

public interface AccountService {

	List<Account> findAllAccounts();

	Account createAccount(Account account);

	Account getAccountByAccountNumber(Long accountNumber);
	
	String deleteAccount(Account account);

	Account updateAccount(Long accNumber, Account account);

	

}
