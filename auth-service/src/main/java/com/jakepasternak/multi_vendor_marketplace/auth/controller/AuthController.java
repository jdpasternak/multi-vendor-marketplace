package com.jakepasternak.multi_vendor_marketplace.auth.controller;

import com.jakepasternak.multi_vendor_marketplace.auth.domain.AuthUser;
import com.jakepasternak.multi_vendor_marketplace.auth.domain.dto.AuthUserResponseDTO;
import com.jakepasternak.multi_vendor_marketplace.auth.domain.dto.LoginRequestDTO;
import com.jakepasternak.multi_vendor_marketplace.auth.domain.dto.RegisterRequestDTO;
import com.jakepasternak.multi_vendor_marketplace.auth.domain.dto.ValidateTokenRequestDTO;
import com.jakepasternak.multi_vendor_marketplace.auth.mapper.CustomMapper;
import com.jakepasternak.multi_vendor_marketplace.auth.service.AuthService;
import com.jakepasternak.multi_vendor_marketplace.auth.web.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    AuthService authService;
    CustomMapper mapper;
    JwtService jwtService;

    public AuthController(AuthService authService, CustomMapper mapper, JwtService jwtService) {
        this.authService = authService;
        this.mapper = mapper;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    ResponseEntity<AuthUserResponseDTO> register(@RequestBody RegisterRequestDTO registerRequest) {
        log.info("{}", registerRequest);
        var authUser = authService.register(registerRequest.getUsername(), registerRequest.getPassword());
        var dto = mapper.toResponseDTO(authUser);
        dto.setToken(jwtService.generateToken(authUser));
        var httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(dto.getToken());
        return ResponseEntity.ok().headers(httpHeaders).body(dto);
    }

    @PostMapping("/login")
    ResponseEntity<AuthUserResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        log.info("{}", loginRequest);
        var authUser = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        var dto = mapper.toResponseDTO(authUser);
        dto.setToken(jwtService.generateToken(authUser));
        var httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(dto.getToken());
        return ResponseEntity.ok().headers(httpHeaders).body(dto);
    }

    @PostMapping("/validate-token")
    ResponseEntity<AuthUserResponseDTO> validateToken(@RequestBody ValidateTokenRequestDTO validateTokenRequestDTO) {

        var auth = SecurityContextHolder.getContext().getAuthentication();
        var authUser = (AuthUser) auth.getPrincipal();

        var dto = mapper.toResponseDTO(authUser);
        dto.setToken(jwtService.generateToken(authUser));
        var httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(dto.getToken());
        return ResponseEntity.ok().headers(httpHeaders).body(dto);
    }

}
