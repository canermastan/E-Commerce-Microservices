package com.canermastan.accountservice.controller;

import com.canermastan.accountservice.entity.Account;
import com.canermastan.accountservice.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(accountService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Account> update(@RequestBody @Valid Account account){
        return ResponseEntity.ok(accountService.update(account));
    }

    @DeleteMapping
    public void deleteById(Long id){
        accountService.deleteById(id);
    }
}
