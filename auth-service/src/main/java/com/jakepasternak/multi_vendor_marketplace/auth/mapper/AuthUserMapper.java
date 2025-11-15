package com.jakepasternak.multi_vendor_marketplace.auth.mapper;

import com.jakepasternak.multi_vendor_marketplace.auth.domain.AuthRole;
import com.jakepasternak.multi_vendor_marketplace.auth.domain.AuthUser;
import com.jakepasternak.multi_vendor_marketplace.auth.domain.dto.AuthUserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthUserMapper {
    AuthUserResponseDTO toResponseDTO(AuthUser user);


}
