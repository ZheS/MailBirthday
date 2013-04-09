package com.svwpu.mailbirthday.sendmail.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

public class LocalUserDetails implements UserDetails, CredentialsContainer {
	private static final long serialVersionUID = -7071732709337194907L;

	private final String username;
	private String password;
	private final Set<GrantedAuthority> authorities;

	private final boolean enabled;
	private final boolean accountNonExpired;
	private final boolean accountNonLocked;
	private final boolean credentialsNonExpired;

	public LocalUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		this(username, password, authorities, true, true, true, true);
	}

	public LocalUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
			boolean enabled, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired) {
		if ((username == null) || ("".equals(username)) || (password == null)) {
			throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
		}

		this.username = username;
		this.password = password;
		this.authorities = new HashSet<GrantedAuthority>();
		for (GrantedAuthority ga : authorities) {
			Assert.notNull(ga, "GrantedAuthority list cannot contain any null elements");
			this.authorities.add(ga);
		}
		Assert.isTrue(this.authorities.size() == authorities.size(), "GrantedAuthority lists should have the same size");

		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void eraseCredentials() {
		password = null;
	}

	public boolean equals(Object rhs) {
		if (rhs instanceof User) {
			return this.username.equals(((LocalUserDetails) rhs).username);
		}
		return false;
	}

	public int hashCode() {
		return this.username.hashCode();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(": ");
		sb.append("Username: ").append(this.username).append("; ");
		sb.append("Password: [PROTECTED]; ");
		sb.append("Enabled: ").append(this.enabled).append("; ");
		sb.append("AccountNonExpired: ").append(this.accountNonExpired).append("; ");
		sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired).append("; ");
		sb.append("AccountNonLocked: ").append(this.accountNonLocked).append("; ");
		boolean first;
		if (!(this.authorities.isEmpty())) {
			sb.append("Granted Authorities: ");

			first = true;
			for (GrantedAuthority auth : this.authorities) {
				if (!(first)) {
					sb.append(",");
				}
				first = false;

				sb.append(auth);
			}
		} else {
			sb.append("Not granted any authorities");
		}

		return sb.toString();
	}
}
