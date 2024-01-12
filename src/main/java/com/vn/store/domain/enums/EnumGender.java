package com.vn.store.domain.enums;

public enum EnumGender {
	MALE("male"), FEMALE("female"), OTHER("other");

	private final String value;

	EnumGender(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
