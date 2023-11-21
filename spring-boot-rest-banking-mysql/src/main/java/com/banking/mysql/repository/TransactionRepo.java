package com.banking.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.mysql.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction,	Long>{

}
