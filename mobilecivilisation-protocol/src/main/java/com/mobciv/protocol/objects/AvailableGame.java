package com.mobciv.protocol.objects;

import com.mobciv.datamodel.JsonSerializable;

public class AvailableGame implements JsonSerializable{

	private String roomId;
	private int[] availableCivilisations;

	public AvailableGame(String roomId, int[] availableCivilisations) {
		this.roomId = roomId;
		this.availableCivilisations = availableCivilisations;
	}
	
	public int getAvailableCivilisationsCount() {
		return availableCivilisations.length;
	}
		
	public int getAvailableCivilisationId(int index) {
		return availableCivilisations[index];
	}
	
	public String getRoomId() {
		return roomId;
	}
	
}
