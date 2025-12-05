package com.jakepasternak.multi_vendor_marketplace.crew.service;

import com.jakepasternak.multi_vendor_marketplace.crew.domain.CrewMembership;
import com.jakepasternak.multi_vendor_marketplace.crew.domain.CrewMembershipResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface CrewMembershipService extends GenericService<CrewMembership> {
    List<CrewMembership> findCrewMembersByCrewId(@NotNull @NotBlank String crewId);

    CrewMembership addMemberToCrew(String crewId, CrewMembership crewMembership);

    void removeMemberFromCrew(String crewId, String userId);

    CrewMembership findByCrewIdAndUserId(@NotNull @NotBlank String crewId, @NotNull @NotBlank String userId);
}
