package com.example.hms.utils;

public enum MedicalTitle {
	DOCTOR(1), NURSE(2), CARE_TAKER(2);
	
	private int code;
	
	MedicalTitle(int code) {
		this.code = code;
	}
	
	public int getTitleCode() {
		return code;
	}

}
