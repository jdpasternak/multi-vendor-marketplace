package com.jakepasternak.multi_vendor_marketplace.user.exception;

import lombok.AllArgsConstructor;


public class UserDoesNotExistException extends RuntimeException {
    public UserDoesNotExistException() { super(); }
    public UserDoesNotExistException(String userId) { super("User does not exits, id: " + userId); }
}
