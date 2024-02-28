package com.bik.miniblog.enums;

public enum UserRole {
    ADMIN("ADMIN"),
    VISITOR("VISITOR"),
    USER("USER");

    private String userRole;
    UserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }
}
