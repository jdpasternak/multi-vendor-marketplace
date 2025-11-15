package com.jakepasternak.multi_vendor_marketplace.user.service;

import com.jakepasternak.multi_vendor_marketplace.user.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
