package com.jakepasternak.multi_vendor_marketplace.auth.domain;

public enum AuthRole {
    MANAGER("Manager"),
    CREW_LEADER("Crew Leader"),
    CREW_MEMBER("Crew Member"),
    CUSTOMER("Customer"),
    ADMIN("Admin");

    final String label;

    AuthRole(String label) {
        this.label = label;
    }

    public String getName() {return label;}
    public String getAuthority() {return "ROLE_" + name();}
}
