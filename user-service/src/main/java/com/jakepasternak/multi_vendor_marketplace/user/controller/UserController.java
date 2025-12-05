package com.jakepasternak.multi_vendor_marketplace.user.controller;

import com.jakepasternak.multi_vendor_marketplace.user.domain.UserRequest;
import com.jakepasternak.multi_vendor_marketplace.user.domain.UserResponse;
import com.jakepasternak.multi_vendor_marketplace.user.mapper.UserMapper;
import com.jakepasternak.multi_vendor_marketplace.user.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
TODO
- [ ] Events
-
 */

@Validated
@RestController
@AllArgsConstructor
public class UserController {

    UserService userService;
    UserMapper userMapper;

    @GetMapping
    ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok().body(userService.findAll()
                .parallelStream()
                .map(u -> userMapper.toResponse(u))
                .toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<UserResponse> getUser(@PathVariable @NotBlank @NotNull String id) {
        return ResponseEntity.ok().body(userMapper.toResponse(userService.findById(id).orElse(null)));
    }

    @PostMapping
    ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest requestBody) {
        return ResponseEntity.ok().body(userMapper.toResponse(userService.create(requestBody)));
    }

    @PutMapping("/{id}")
    ResponseEntity<UserResponse> updateUser(@PathVariable @NotNull @NotBlank String id, @RequestBody @Valid UserRequest requestBody) {
        return ResponseEntity.ok().body(userMapper.toResponse(userService.updateById(id, requestBody)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable @NotNull @NotBlank String id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
