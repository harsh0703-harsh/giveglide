package org.microservice.enums;

import lombok.Getter;

@Getter
public enum Permissions {
    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    ADMIN_UPDATE("admin:update"),
    SADMIN_CREATE("sadmin:create"),
    SADMIN_READ("sadmin:read"),
    SADMIN_DELETE("sadmin:delete"),
    SADMIN_UPDATE("sadmin:update"),
    USER_CREATE("user:create"),
    USER_READ("user:read"),
    USER_DELETE("user:delete"),
    USER_UPDATE("user:update");

    private final String permission;

    Permissions(String permissionName) {
        this.permission = permissionName;
    }

    public String getPermissionName() {
        return permission;
    }
}
