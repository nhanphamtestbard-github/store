package com.vn.store.domain.enums;

public enum EnumPositon {
	MD("Managing Director"),
	VD("Vice Director"),
	MNG("Manager"), 
	CA("Chief Accountant"), 
	TL("Team Leader"),
	PL("Project Leader"),
	BRSE("Bridge Software Engineer"),
	IT("IT-Admin"),
	SUBPL("Sub PL"),
	TESTER("Tester"),
	DEV("Developer"),
	COMTOR("Comtor"),
	OFF("Officer"),
	SALE("Saler"),
	ACC("Accountant"),
	ITHELP("IT Helpdesk"),
	MEM("Member"),
	OJT("On the job training"),
	INTERN("Intership");

	private final String value;

	EnumPositon(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
