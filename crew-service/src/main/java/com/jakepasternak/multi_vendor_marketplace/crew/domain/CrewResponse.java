package com.jakepasternak.multi_vendor_marketplace.crew.domain;

import lombok.Data;

@Data
public class CrewResponse {
    private String id;
    private String name;
    private Boolean active;
}
