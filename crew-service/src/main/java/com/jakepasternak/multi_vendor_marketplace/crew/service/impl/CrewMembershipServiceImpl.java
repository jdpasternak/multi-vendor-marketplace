package com.jakepasternak.multi_vendor_marketplace.crew.service.impl;

import com.jakepasternak.multi_vendor_marketplace.crew.exception.CrewNotFoundException;
import com.jakepasternak.multi_vendor_marketplace.crew.mapper.CrewMapper;
import com.jakepasternak.multi_vendor_marketplace.crew.domain.CrewMembership;
import com.jakepasternak.multi_vendor_marketplace.crew.exception.CrewMembershipNotFoundException;
import com.jakepasternak.multi_vendor_marketplace.crew.repository.CrewMembershipRepository;
import com.jakepasternak.multi_vendor_marketplace.crew.repository.CrewRepository;
import com.jakepasternak.multi_vendor_marketplace.crew.service.CrewMembershipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CrewMembershipServiceImpl implements CrewMembershipService {
    CrewMembershipRepository repository;
    CrewRepository crewRepository;
    CrewMapper mapper;

    @Override
    public List<CrewMembership> findCrewMembersByCrewId(String crewId) {
        return repository.findByCrewId(crewId);
    }

    @Override
    public CrewMembership addMemberToCrew(String crewId, CrewMembership crewMembership) {
        var crew = crewRepository.findById(crewId).orElseThrow(() -> new CrewNotFoundException(crewId));

        crewMembership.setCrew(crew);
        return repository.save(crewMembership);
    }

    @Override
    public void removeMemberFromCrew(String crewId, String userId) {

    }

    @Override
    public CrewMembership findByCrewIdAndUserId(String crewId, String userId) {
        return repository.findByCrewIdAndUserId(crewId, userId);
    }

    @Override
    public List<CrewMembership> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<CrewMembership> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public CrewMembership create(CrewMembership request) {
        return repository.save(request);
    }

    @Override
    public CrewMembership updateById(String id, CrewMembership request) {
        if (repository.findById(id).isPresent()) {
            request.setId(id);
             return repository.save(request);
        } else {
            throw new CrewMembershipNotFoundException(id);
        }
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
