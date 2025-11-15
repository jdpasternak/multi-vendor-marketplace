package com.jakepasternak.multi_vendor_marketplace.user.controller;

import com.jakepasternak.multi_vendor_marketplace.user.domain.User;
import com.jakepasternak.multi_vendor_marketplace.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping
    ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }
}
