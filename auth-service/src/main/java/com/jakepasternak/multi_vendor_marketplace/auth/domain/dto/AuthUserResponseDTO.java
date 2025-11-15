package com.jakepasternak.multi_vendor_marketplace.auth.domain.dto;

import com.jakepasternak.multi_vendor_marketplace.auth.domain.AuthRole;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;

@Data
public class AuthUserResponseDTO {

    private String id;

    private String email;

    private String status;

    private Set<String> roles;

    private Timestamp createdAt;

    private String token;
}
