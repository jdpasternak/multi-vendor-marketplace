package com.jakepasternak.multi_vendor_marketplace.auth.repository;

import com.jakepasternak.multi_vendor_marketplace.auth.domain.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByEmail(String email);

}
