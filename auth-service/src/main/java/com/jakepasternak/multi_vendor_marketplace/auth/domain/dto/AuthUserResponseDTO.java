package com.jakepasternak.multi_vendor_marketplace.auth.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jakepasternak.multi_vendor_marketplace.auth.domain.AuthUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"passwordHash"})
public class AuthUserResponseDTO extends AuthUser {
    private String token;
}
