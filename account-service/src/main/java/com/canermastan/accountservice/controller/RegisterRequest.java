package com.canermastan.accountservice.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(@NotBlank String firstName, @NotBlank String lastName, @NotBlank @Email String email, @NotBlank String password) {
}
