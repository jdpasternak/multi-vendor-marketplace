package com.jakepasternak.multi_vendor_marketplace.auth.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String username) {
        super("User with email already exists: " + username);
    }
}
