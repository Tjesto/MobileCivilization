package com.mobciv.protocol.objects;

public enum Civilisations {
	ROMANS(0x00),
	RUSSIANS(0x01),
	CELTIC(0x02),
	BABYLONIANS(0x10),
	ZULUS(0x11),
	JAPANESE(0x12),
	GERMANS(0x20),
	FRENCH(0x21),
	VIKINGS(0x22),
	EGYPTIANS(0x30),
	AZTECS(0x31),
	SPANISH(0x32),
	AMERICANS(0x40),
	CHINESE(0x41),
	PERSIANS(0x42),
	GREEKS(0x50),
	ENGLISH(0x51),
	CARTHAGINIANS(0x52),
	INDIANS(0x60),
	MONGOLS(0x61),
	SIOUX(0x62),
	BARBARIANS(0x70);
	
	private int civilisationId;
	
	Civilisations(int id) {
		this.civilisationId = id;
	}
	
	public int getCivilisationId() {
		return civilisationId;
	}
	
	public Civilisations getCivilisation(int id) {
		for (Civilisations c : values()) {
			if (c.civilisationId == id) {
				return c;
			}
		}
		return null;
	}
}
