package com.jakepasternak.multi_vendor_marketplace.crew.mapper;

import com.jakepasternak.multi_vendor_marketplace.crew.domain.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CrewMapper {
    CrewResponse toResponse(Crew crew);
    @Mapping(target = "crewId", expression = "java(crewMembership.getCrew().getId())")
    @Mapping(target = "role", expression = "java(crewMembership.getRole().getName())")
    CrewMembershipResponse toResponse(CrewMembership crewMembership);
    Crew toDomain(CrewRequest request);
    CrewMembership toDomain(CrewMembershipRequest request);
}
