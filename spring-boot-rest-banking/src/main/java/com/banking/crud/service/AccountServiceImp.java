package com.banking.crud.service;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.crud.entity.Account;
import com.banking.crud.repo.AccountRepo;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountRepo repo;

	@Override
	public List<Account> findAllAccounts() {
		return repo.findAll();
	}

	@Override
	public Account createAccount(Account account) {
		return repo.insert(account);
	}


	@Override
	public Account updateAccount(Long accNumber, Account account) {
		Account number = getAccountByAccountNumber(accNumber);
		account.setId(number.getId());
		return repo.save(account);
	}

	@Override
	public String deleteAccount(Account account) {
		repo.delete(account);
		return "deleted";
	}
	
	public Account getAccountByAccountNumber(Long accountNumber) {
		return repo.findByAccountNumber(accountNumber);
	}

}