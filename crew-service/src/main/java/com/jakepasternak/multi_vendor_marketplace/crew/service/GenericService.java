package com.jakepasternak.multi_vendor_marketplace.crew.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    List<T> findAll();

    Optional<T> findById(@NotNull @NotBlank String id);

    T create(@Valid T request);

    T updateById(@NotNull @NotBlank String id, @Valid T request);

    void deleteById(@NotNull @NotBlank String id);
}
