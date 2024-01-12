package com.vn.store.domain.enums;

public enum EnumRole {
	USER("user"), ADMIN("admin"), CUSTOMER("customer");

	private final String value;

	EnumRole(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
