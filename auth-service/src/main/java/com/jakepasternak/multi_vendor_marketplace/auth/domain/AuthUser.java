package com.jakepasternak.multi_vendor_marketplace.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    @JsonIgnore
    private String password;

    private String status;

    private List<GrantedAuthority> authorities = new ArrayList<>();

//    @Enumerated(EnumType.STRING)
//    @ElementCollection(fetch = FetchType.LAZY)
//    private Set<AuthRole> roles;

    @CreatedDate
    private Timestamp createdAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
