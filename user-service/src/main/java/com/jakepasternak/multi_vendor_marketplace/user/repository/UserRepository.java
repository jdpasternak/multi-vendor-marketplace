package com.jakepasternak.multi_vendor_marketplace.user.repository;

import com.jakepasternak.multi_vendor_marketplace.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
