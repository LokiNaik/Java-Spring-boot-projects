package com.banking.crud.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.banking.crud.entity.Account;

@Repository
public interface AccountRepo extends MongoRepository<Account, Long>{

	Account findByAccountNumber(Long accountNumber);
	

}
