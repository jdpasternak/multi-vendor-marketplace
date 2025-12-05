package com.jakepasternak.multi_vendor_marketplace.user.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "APP_USER")
//@Table(name = "APP_USER")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String firstName;
    String lastName;

    String email;

    @ManyToMany
    List<Role> roles;
}
