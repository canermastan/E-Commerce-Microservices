package com.canermastan.accountservice.service;

import com.canermastan.accountservice.controller.AuthenticationResponse;
import com.canermastan.accountservice.controller.LoginRequest;
import com.canermastan.accountservice.controller.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse login(LoginRequest loginRequest);
    AuthenticationResponse register(RegisterRequest registerRequest);
}
