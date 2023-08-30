package com.crud.springcrud.controller;

import com.crud.springcrud.entity.Account;
import com.crud.springcrud.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping("{username}")
    public ResponseEntity<Account> getAccountByUsername(@PathVariable(name = "username") String username) {
        return ResponseEntity.ok(accountService.findByUsername(username));
    }

    private URI getLocation(Integer id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
