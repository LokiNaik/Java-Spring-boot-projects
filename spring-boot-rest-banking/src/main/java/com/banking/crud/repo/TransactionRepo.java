package com.banking.crud.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.banking.crud.entity.Transaction;

@Repository
public interface TransactionRepo extends MongoRepository<Transaction, String>{

}
