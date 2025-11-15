package com.jakepasternak.multi_vendor_marketplace.auth.domain.dto;

import lombok.Data;

@Data
public class ValidateTokenRequestDTO {
    private String token;
}
