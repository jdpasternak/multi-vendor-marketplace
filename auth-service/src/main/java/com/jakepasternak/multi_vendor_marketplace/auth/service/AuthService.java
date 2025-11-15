package com.jakepasternak.multi_vendor_marketplace.auth.service;

import com.jakepasternak.multi_vendor_marketplace.auth.domain.AuthUser;
import com.jakepasternak.multi_vendor_marketplace.auth.domain.dto.AuthUserResponseDTO;

public interface AuthService {
    AuthUser register(String username, String password);
    AuthUser login(String username, String password);
    AuthUser validateToken(String token);
}
