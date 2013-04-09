package com.svwpu.mailbirthday.sendmail.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public class LocalGrantedAuthority implements GrantedAuthority {
	private static final long serialVersionUID = -2034345191085563780L;

	private final RoleType role;

	public LocalGrantedAuthority(RoleType role) {
		Assert.notNull(role, "传入RoleType参数不为空！");
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return role.name();
	}

	public boolean equals(Object obj) {
		if (obj instanceof String) {
			return obj.equals(this.role);
		}

		if (obj instanceof GrantedAuthority) {
			GrantedAuthority attr = (GrantedAuthority) obj;

			return this.role.equals(attr.getAuthority());
		}

		return false;
	}

	public int hashCode() {
		return this.role.hashCode();
	}

	public String toString() {
		return this.role.name();
	}
}
