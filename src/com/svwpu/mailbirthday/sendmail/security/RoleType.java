package com.svwpu.mailbirthday.sendmail.security;

public enum RoleType {
    ROLE_USER("common_user"), ROLE_ADMIN("admin");

    private final String description;

    private RoleType(String description) {
	this.description = description;
    }

    public String getDescription() {
	return description;
    }

    public static RoleType parseRoleType(String name) {
	for (RoleType r : RoleType.values()) {
	    if (r.getDescription().equals(name)) {
		return r;
	    }
	}
	throw new IllegalArgumentException("传入的RoleType名称不正确");
    }
}
