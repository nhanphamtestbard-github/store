package com.vn.store.domain.enums;

public enum EnumDepartment {
	GA("General Affairs Department"), 
	DEV("Development"), 
	TDS("Traning & Development Support"),  
	BPO("Business Process Outsourcing"),
	BAO("Bussiness Analysic Office"),
	BLJ("B-Luck Jobber"),
	DTP("Desktop Publishing");

	private final String value;

	EnumDepartment(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
