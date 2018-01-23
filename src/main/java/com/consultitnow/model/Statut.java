package com.consultitnow.model;

public enum Statut {

	INPROCESS(0),
	WAITING(1),
	ORDERED(2);

private int value;

private Statut(int value) {
	this.value = value;
}

public int getValue() {
	return value;
}	
	
}
