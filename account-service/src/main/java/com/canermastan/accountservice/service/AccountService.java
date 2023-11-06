package com.canermastan.accountservice.service;

import com.canermastan.accountservice.entity.Account;

public interface AccountService {
    Account findByEmail(String email);
    Account findById(Long id);
    Account update(Account account);
    void deleteById(Long id);
}
