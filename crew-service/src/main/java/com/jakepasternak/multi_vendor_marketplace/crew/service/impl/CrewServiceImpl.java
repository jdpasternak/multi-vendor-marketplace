package com.jakepasternak.multi_vendor_marketplace.crew.service.impl;

import com.jakepasternak.multi_vendor_marketplace.crew.domain.Crew;
import com.jakepasternak.multi_vendor_marketplace.crew.exception.CrewNotFoundException;
import com.jakepasternak.multi_vendor_marketplace.crew.repository.CrewRepository;
import com.jakepasternak.multi_vendor_marketplace.crew.service.CrewService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@AllArgsConstructor
public class CrewServiceImpl implements CrewService {

    CrewRepository repository;

    @Override
    public List<Crew> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Crew> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Crew create(Crew crew) {
        if (crew.getActive() == null) {
            crew.setActive(true);
        }
        return repository.save(crew);
    }

    @Override
    public Crew updateById(String id, Crew crew) {
        if (repository.findById(id).isPresent()) {
            crew.setId(id);
            log.info("Updating, crew: {}", crew);
            return repository.save(crew);
        } else {
            log.warn("Attempted to update nonexistent crew, id: {}", id);
            throw new CrewNotFoundException(id);
        }
    }

    @Override
    public void deleteById(String id) {
        repository.findById(id).ifPresentOrElse(c -> {
            c.setActive(false);
            repository.save(c);
            log.info("Crew deactivated, id: {}", id);
        }, () -> {
            log.info("Attempted to deactivate nonexistent crew, id: {}", id);
        });
    }
}
