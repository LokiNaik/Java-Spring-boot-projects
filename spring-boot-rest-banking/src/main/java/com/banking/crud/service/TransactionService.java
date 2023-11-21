package com.banking.crud.service;

import java.util.List;

import com.banking.crud.entity.Transaction;

public interface TransactionService {

	List<Transaction> findAllTransactions();

	Transaction getTransactionById(Long id);

	Transaction createTransaction(Transaction transaction);

	Transaction updateTransaction(Transaction transaction);

	void deleteTransaction(Long id);
}
