package com.consultitnow.app.entity;

public enum Status {

	Processing(-1), Saved(0), Ordered(1);

	Integer value;

	public Integer getValue() {
		return value;
	}

	public static Integer getValue(String stringValue) {

		switch (stringValue) {
		case "processing":
			return Processing.getValue();

		case "saved":
			return Saved.getValue();

		case "ordered":
			return Ordered.getValue();

		default:
			return null;
		}

	}

	Status(Integer value) {
		this.value = value;
	}
}
