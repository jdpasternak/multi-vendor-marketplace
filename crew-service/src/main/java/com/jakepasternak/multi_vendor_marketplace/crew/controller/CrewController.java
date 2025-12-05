package com.jakepasternak.multi_vendor_marketplace.crew.controller;

import com.jakepasternak.multi_vendor_marketplace.crew.domain.CrewMembershipRequest;
import com.jakepasternak.multi_vendor_marketplace.crew.mapper.CrewMapper;
import com.jakepasternak.multi_vendor_marketplace.crew.domain.CrewMembershipResponse;
import com.jakepasternak.multi_vendor_marketplace.crew.domain.CrewRequest;
import com.jakepasternak.multi_vendor_marketplace.crew.domain.CrewResponse;
import com.jakepasternak.multi_vendor_marketplace.crew.service.CrewMembershipService;
import com.jakepasternak.multi_vendor_marketplace.crew.service.CrewService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
public class CrewController {

    CrewService crewService;
    CrewMembershipService crewMembershipService;
    CrewMapper mapper;

    @GetMapping
    public ResponseEntity<List<CrewResponse>> getCrews() {
        return ResponseEntity.ok().body(crewService.findAll().stream().map(c -> mapper.toResponse(c)).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrewResponse> getCrewById(@PathVariable @NotNull @NotBlank String id) {
        var crew = crewService.findById(id);
        return crew.map(value -> ResponseEntity.ok().body(mapper.toResponse(value))).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<CrewResponse> createCrew(@RequestBody @Valid CrewRequest request) {
        return ResponseEntity.ok().body(mapper.toResponse(crewService.create(mapper.toDomain(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrewResponse> updateCrewById(@PathVariable @NotNull @NotBlank String id, @RequestBody @Valid CrewRequest request) {
        return ResponseEntity.ok().body(mapper.toResponse(crewService.updateById(id, mapper.toDomain(request))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCrewById(@PathVariable @NotNull @NotBlank String id) {
        crewService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/members")
    public ResponseEntity<List<CrewMembershipResponse>> getCrewMembersForCrew(@PathVariable @NotNull @NotBlank String id) {
        return ResponseEntity.ok().body(crewMembershipService.findCrewMembersByCrewId(id)
                .stream()
                .map(cm -> mapper.toResponse(cm))
                .toList());
    }

    @PostMapping("/{id}/members")
    public ResponseEntity<CrewMembershipResponse> addMemberToCrew(@PathVariable @NotNull @NotBlank String id, @RequestBody CrewMembershipRequest request) {
        return ResponseEntity.ok().body(mapper.toResponse(crewMembershipService.addMemberToCrew(id, mapper.toDomain(request))));
    }

    @DeleteMapping("/{id}/members/{userId}")
    public ResponseEntity<CrewMembershipResponse> removeMemberFromCrew(
            @PathVariable @NotNull @NotBlank String id,
            @PathVariable @NotNull @NotBlank String userId) {
        var crewMembership = crewMembershipService.findByCrewIdAndUserId(id, userId);
        crewMembershipService.deleteById(crewMembership.getId());
        return ResponseEntity.ok().build();
    }
}
