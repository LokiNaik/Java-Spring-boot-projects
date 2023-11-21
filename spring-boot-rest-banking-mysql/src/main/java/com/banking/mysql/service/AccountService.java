package com.banking.mysql.service;

import java.util.List;
import java.util.Optional;

import com.banking.mysql.entity.Account;

public interface AccountService {

	List<Account> getAllAccounts();

	Account createAccount(Account account);

	Optional<Account> getAccountById(Long id);

}
