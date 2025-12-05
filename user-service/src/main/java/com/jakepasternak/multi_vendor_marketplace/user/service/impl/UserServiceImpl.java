package com.jakepasternak.multi_vendor_marketplace.user.service.impl;

import com.jakepasternak.multi_vendor_marketplace.user.domain.User;
import com.jakepasternak.multi_vendor_marketplace.user.domain.UserRequest;
import com.jakepasternak.multi_vendor_marketplace.user.exception.UserDoesNotExistException;
import com.jakepasternak.multi_vendor_marketplace.user.mapper.UserMapper;
import com.jakepasternak.multi_vendor_marketplace.user.repository.UserRepository;
import com.jakepasternak.multi_vendor_marketplace.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository repository;
    UserMapper mapper;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public User create(UserRequest request) {
        return repository.save(mapper.toDomain(request));
    }

    @Override
    public User updateById(String id, UserRequest request) {
        if (repository.findById(id).isPresent()) {
            var user = mapper.toDomain(request);
            user.setId(id);
            return repository.save(user);
        } else {
            throw new UserDoesNotExistException();
        }
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
