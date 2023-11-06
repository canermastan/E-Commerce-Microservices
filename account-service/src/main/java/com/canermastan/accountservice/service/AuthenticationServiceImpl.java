package com.canermastan.accountservice.service;

import com.canermastan.accountservice.controller.AuthenticationResponse;
import com.canermastan.accountservice.controller.LoginRequest;
import com.canermastan.accountservice.controller.RegisterRequest;
import com.canermastan.accountservice.entity.Account;
import com.canermastan.accountservice.entity.Role;
import com.canermastan.accountservice.exception.AccountAlreadyExistsException;
import com.canermastan.accountservice.repository.AccountRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.email(),
                        loginRequest.password()
                )
        );
        var user = accountRepository.findByEmail(loginRequest.email()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken, user.getRole().name());
    }

    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        if (accountRepository.findByEmail(registerRequest.email()).isPresent()) {
            throw new AccountAlreadyExistsException("This account already exists");
        }
        Account account = new Account();
        account.setFirstName(registerRequest.firstName());
        account.setLastName(registerRequest.lastName());
        account.setEmail(registerRequest.email());
        account.setPassword(passwordEncoder.encode(registerRequest.password()));
        account.setRole(Role.USER);
        accountRepository.save(account);
        var jwtToken = jwtService.generateToken(account);
        return new AuthenticationResponse(jwtToken, account.getRole().name());
    }
}
