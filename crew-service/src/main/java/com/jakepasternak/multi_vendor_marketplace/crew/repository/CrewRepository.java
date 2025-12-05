package com.jakepasternak.multi_vendor_marketplace.crew.repository;

import com.jakepasternak.multi_vendor_marketplace.crew.domain.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<Crew, String> {
}
