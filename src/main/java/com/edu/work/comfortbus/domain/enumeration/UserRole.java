package com.edu.work.comfortbus.domain.enumeration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.edu.work.comfortbus.domain.enumeration.UserPermission.*;

public enum UserRole {
    CLIENT(Set.of(COMMENT_READ, COMMENT_WRITE, BUS_READ)),
    DRIVER(Set.of(COMMENT_READ, COMMENT_WRITE, RIDE_READ, BUS_READ)),
    ADMIN(Set.of(COMMENT_READ, COMMENT_WRITE, RIDE_READ, RIDE_WRITE, BUS_READ, BUS_WRITE));

    private final Set<UserPermission> permissions;

    UserRole(final Set<UserPermission> userPermissions) {
        this.permissions = userPermissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<GrantedAuthority> getGrantedAuthorities() {
        Set<GrantedAuthority> collect = getPermissions().stream()
                .map(e -> new SimpleGrantedAuthority(e.getPermission()))
                .collect(Collectors.toSet());

        collect.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

        return collect;
    }
}
