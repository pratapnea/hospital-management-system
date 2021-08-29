package com.example.hms.model;

public enum Gender {
	MALE(1), FEMALE(2), OTHER(3);
	
	private int code;
	
	Gender(int code){
		this.code = code;
	}
	
	public int getGenderCode() {
		return code;
	}
}
