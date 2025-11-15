package com.jakepasternak.multi_vendor_marketplace.user.service.impl;

import com.jakepasternak.multi_vendor_marketplace.user.domain.User;
import com.jakepasternak.multi_vendor_marketplace.user.repository.UserRepository;
import com.jakepasternak.multi_vendor_marketplace.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
