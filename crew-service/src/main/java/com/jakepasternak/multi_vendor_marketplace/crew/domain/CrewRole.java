package com.jakepasternak.multi_vendor_marketplace.crew.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "crew_role")
public class CrewRole {
    @Id
    private String name;

    private String description;
}
