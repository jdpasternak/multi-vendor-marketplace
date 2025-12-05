package com.jakepasternak.multi_vendor_marketplace.crew.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CrewMembershipRequest {
    @NotNull
    @NotBlank
    private String userId;
    private Boolean isLeader = false;
    @NotNull
    private LocalDate startDate;
    private LocalDate endDate;
}
