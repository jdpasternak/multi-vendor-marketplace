package com.jakepasternak.multi_vendor_marketplace.crew.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CrewRequest {
    @NotBlank @NotNull
    private String name;
    @NotNull
    private Boolean active;
}
