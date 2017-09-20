package ru.kerporation.model;

//import org.springframework.security.core.GrantedAuthority;

//public enum Role implements GrantedAuthority {
public enum Role {
	ROLE_USER,
	ROLE_ADMIN;

//	@Override
	public String getAuthority() {
		return name();
	}
}
