package com.javachinna.dto;

public enum Profession {
    DOCTOR("doctor"),STUDENT("student");
    private String profession;

    public String getProfession() {
        return profession;
    }

    Profession(final String profession) {
        this.profession = profession;
    }
}
