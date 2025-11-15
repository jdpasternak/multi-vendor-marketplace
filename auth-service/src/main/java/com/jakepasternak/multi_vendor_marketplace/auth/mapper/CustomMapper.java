package com.jakepasternak.multi_vendor_marketplace.auth.mapper;

import com.jakepasternak.multi_vendor_marketplace.auth.domain.AuthUser;
import com.jakepasternak.multi_vendor_marketplace.auth.domain.dto.AuthUserResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomMapper {
    AuthUserResponseDTO toResponseDTO(AuthUser authUser);
}
