package com.jakepasternak.multi_vendor_marketplace.crew.repository;

import com.jakepasternak.multi_vendor_marketplace.crew.domain.Crew;
import com.jakepasternak.multi_vendor_marketplace.crew.domain.CrewMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrewMembershipRepository extends JpaRepository<CrewMembership, String> {
    List<CrewMembership> findByCrewId(String crewId);

    CrewMembership findByCrewIdAndUserId(String crewId, String userId);
}
