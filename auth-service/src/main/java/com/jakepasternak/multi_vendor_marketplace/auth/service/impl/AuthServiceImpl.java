package com.jakepasternak.multi_vendor_marketplace.auth.service.impl;

import com.jakepasternak.multi_vendor_marketplace.auth.domain.AuthUser;
import com.jakepasternak.multi_vendor_marketplace.auth.exception.IncorrectPasswordException;
import com.jakepasternak.multi_vendor_marketplace.auth.exception.UserAlreadyExistsException;
import com.jakepasternak.multi_vendor_marketplace.auth.exception.UserNotFoundException;
import com.jakepasternak.multi_vendor_marketplace.auth.repository.AuthUserRepository;
import com.jakepasternak.multi_vendor_marketplace.auth.service.AuthService;
import com.jakepasternak.multi_vendor_marketplace.auth.web.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    AuthUserRepository authUserRepository;
    PasswordEncoder passwordEncoder;
    JwtService jwtService;

    @Override
    public AuthUser register(String username, String password) {

        var authUser = authUserRepository.findByEmail(username).orElse(null);
        if (authUser != null) {
            throw new UserAlreadyExistsException(username);
        }

        authUser = authUserRepository.save(new AuthUser(
                null,
                username,
                passwordEncoder.encode(password),
                null,
                null,
                Timestamp.from(Instant.now())));

        return authUser;
    }

    @Override
    public AuthUser login(String username, String password) {
        var authUser = authUserRepository.findByEmail(username).orElse(null);
        if (authUser == null) {
            throw new UserNotFoundException();
        }

        validatePassword(authUser, password);

        return authUser;
    }

    @Override
    public AuthUser validateToken(String token) {
        // Get user details based on token
        var username = jwtService.extractUsername(token);
        // Return the AuthUser
        return authUserRepository.findByEmail(username).orElse(null);
    }

    private void validatePassword(AuthUser authUser, String password) {
        if (!passwordEncoder.matches(password, authUser.getPassword())) {
            throw new IncorrectPasswordException();
        }
    }
}
