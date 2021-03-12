package com.edu.work.comfortbus.domain.enumeration;

public enum UserPermission {

    RIDE_READ("ride:read"),
    RIDE_WRITE("ride:write"),

    COMMENT_READ("comment:read"),
    COMMENT_WRITE("comment:write"),

    BUS_READ("bus:read"),
    BUS_WRITE("bus:write");

    private String permission;

    UserPermission(final String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
