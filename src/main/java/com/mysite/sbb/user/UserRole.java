package com.mysite.sbb.user;

import lombok.Getter;

@Getter
public enum UserRole {
	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");
	
	String value;
	private UserRole(String value) {
		this.value = value;
	}
}
