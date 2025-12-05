package com.jakepasternak.multi_vendor_marketplace.crew.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CrewMembershipResponse {
    private String id;
    private String crewId;
    private String userId;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;

}
