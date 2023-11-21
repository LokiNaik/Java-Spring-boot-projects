package com.banking.mysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.mysql.entity.Account;
import com.banking.mysql.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService{
	
	@Autowired
	private AccountRepository repo;

	@Override
	public List<Account> getAllAccounts() {
		return repo.findAll();
	}

	@Override
	public Account createAccount(Account account) {
		return repo.save(account);
	}

	@Override
	public Optional<Account> getAccountById(Long id) {
		return repo.findById(id);
	}

}
