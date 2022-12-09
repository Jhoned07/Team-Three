package com.example.tienda.util;

public enum ERol {
	ADMIN("SCOPE_admin"),
	USER("SCOPE_user");
	
	String scope;
	
	private ERol(String scope) {
		this.scope=scope;
	}
	
	public String getScope() {
		return this.scope;
	}

}
