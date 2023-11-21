package com.banking.mysql.service;

import java.util.List;
import java.util.Optional;

import com.banking.mysql.entity.Transaction;

public interface TransactionService {

	List<Transaction> getAllTransactions(Transaction tran);
	Transaction createTransaction(Transaction trans);
}
