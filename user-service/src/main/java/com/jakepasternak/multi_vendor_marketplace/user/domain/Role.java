package com.jakepasternak.multi_vendor_marketplace.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Role {

    @Id
    private String name;

    private String description;
}
