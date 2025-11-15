package com.jakepasternak.multi_vendor_marketplace.tenant.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Entity
@Data
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @OneToOne()
    Long userId;

    Boolean disabled;

    @CreatedDate
    Timestamp createdDate;
}
