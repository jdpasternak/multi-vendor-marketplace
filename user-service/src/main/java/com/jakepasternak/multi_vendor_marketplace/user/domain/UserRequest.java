package com.jakepasternak.multi_vendor_marketplace.user.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    @NotNull @NotBlank
    private String firstName;

    @NotNull @NotBlank
    private String lastName;

    @NotNull @Email
    private String email;

    private List<Role> roles;
}
