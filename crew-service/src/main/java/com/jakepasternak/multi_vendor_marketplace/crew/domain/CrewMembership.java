package com.jakepasternak.multi_vendor_marketplace.crew.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "crew_membership",
        uniqueConstraints = {
                // prevents duplicate membership windows with the same start
                @UniqueConstraint(columnNames = {"user_id", "crew_id", "start_time"})
        },
        indexes = {
                @Index(columnList = "user_id"),
                @Index(columnList = "crew_id")
        }
)
public class CrewMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crew_id", nullable = false)
    private Crew crew;

    @Column(nullable = false)
    private LocalDate startDate = LocalDate.now();

    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_name", nullable = false)
    private CrewRole role;
}
