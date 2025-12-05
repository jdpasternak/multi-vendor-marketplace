package com.jakepasternak.multi_vendor_marketplace.crew.exception;

public class CrewMembershipNotFoundException extends RuntimeException {
    public CrewMembershipNotFoundException() {
        super();
    }
    public CrewMembershipNotFoundException(String crewMembershipId) {
        super("CrewMembership not found, id: " + crewMembershipId);
    }
}
