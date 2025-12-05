package com.jakepasternak.multi_vendor_marketplace.user.domain;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
