package com.crud.springcrud.service;

import com.crud.springcrud.entity.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);
    Account findByUsername(String username);
    List<Account> getAccounts();
}
