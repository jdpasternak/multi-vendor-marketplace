package com.jakepasternak.multi_vendor_marketplace.auth.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class RegisterRequestDTO {
    @NotNull
    @NotBlank
    String username;

    @NotNull
    @NotBlank
    String password;
}
