package com.jakepasternak.multi_vendor_marketplace.user.service;

import com.jakepasternak.multi_vendor_marketplace.user.domain.User;
import com.jakepasternak.multi_vendor_marketplace.user.domain.UserRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(@NotNull @NotBlank String id);
    User create(@Valid UserRequest request);
    User updateById(@NotNull @NotBlank String id, @Valid UserRequest request);
    void deleteById(@NotNull @NotBlank String id);
}
