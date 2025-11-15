package com.jakepasternak.multi_vendor_marketplace.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserRole {
    @Id
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "AUTH_ROLE")
    private AuthRole authRole;
}