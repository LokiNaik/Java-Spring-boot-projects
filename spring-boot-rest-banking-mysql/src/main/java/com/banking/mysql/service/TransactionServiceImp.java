package com.banking.mysql.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.mysql.entity.Account;
import com.banking.mysql.entity.Transaction;
import com.banking.mysql.repository.AccountRepository;
import com.banking.mysql.repository.TransactionRepo;

@Service
public class TransactionServiceImp implements TransactionService {
	
	@Autowired
	private TransactionRepo repo;
	
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public List<Transaction> getAllTransactions(Transaction tran) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction createTransaction(Transaction trans) {
		
//		Account account = accountRepo.getById(trans.getAccount().getId());
//		trans.setAccount(account);
		return repo.save(trans);
	}

}
