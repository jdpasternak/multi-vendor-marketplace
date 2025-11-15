package com.jakepasternak.multi_vendor_marketplace.auth.service.impl;

import com.jakepasternak.multi_vendor_marketplace.auth.repository.AuthUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    public UserDetailsServiceImpl(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authUserRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
