package com.sopra.entity;

public enum CongestionLevel {
	NORMAL(0), HIGH(1), VERY_HIGH(2);
	
	private int value;
	
	CongestionLevel(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
}