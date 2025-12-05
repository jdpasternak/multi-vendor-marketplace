package com.jakepasternak.multi_vendor_marketplace.crew.exception;

public class CrewNotFoundException extends RuntimeException {
    public CrewNotFoundException() {
        super();
    }
    public CrewNotFoundException(String crewMembershipId) {
        super("Crew not found, id: " + crewMembershipId);
    }
}
