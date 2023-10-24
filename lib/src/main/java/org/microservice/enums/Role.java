package org.microservice.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(
            Permissions.ADMIN_CREATE,
            Permissions.ADMIN_READ,
            Permissions.ADMIN_DELETE,
            Permissions.ADMIN_UPDATE
    )),
    SADMIN(Set.of(
            Permissions.SADMIN_CREATE,
            Permissions.SADMIN_READ,
            Permissions.SADMIN_DELETE,
            Permissions.SADMIN_UPDATE,
            Permissions.ADMIN_CREATE,
            Permissions.ADMIN_READ,
            Permissions.ADMIN_DELETE,
            Permissions.ADMIN_UPDATE
    )),
    USER(Set.of(
            Permissions.USER_CREATE,
            Permissions.USER_UPDATE,
            Permissions.USER_DELETE,
            Permissions.USER_READ
    ));

    private final Set<Permissions> associatedPermissions;

    Role(Set<Permissions> associatedPermissions) {
        this.associatedPermissions = associatedPermissions;
    }

    public Set<Permissions> getAssociatedPermissions() {
        return associatedPermissions;
    }

    public List<SimpleGrantedAuthority>getAuthorities(){
            var authorities = getAssociatedPermissions().stream()
                    .map(permission-> new SimpleGrantedAuthority(permission.getPermissionName()))
                    .collect(Collectors.toList());

            authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
            return authorities;
    }
}
