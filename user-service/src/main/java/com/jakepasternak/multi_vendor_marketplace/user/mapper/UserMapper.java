package com.jakepasternak.multi_vendor_marketplace.user.mapper;

import com.jakepasternak.multi_vendor_marketplace.user.domain.User;
import com.jakepasternak.multi_vendor_marketplace.user.domain.UserRequest;
import com.jakepasternak.multi_vendor_marketplace.user.domain.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDomain(UserRequest request);
    UserResponse toResponse(User domain);
}
