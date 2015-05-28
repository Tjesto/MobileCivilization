package com.mobciv.protocol.objects;

import com.mobciv.datamodel.JsonSerializable;

public class AvailableGameList implements JsonSerializable {

	private AvailableGame[] games;

	public AvailableGameList(AvailableGame[] games) {
		this.games = games;		
	}
	
	public int getAvailableGamesCount() {
		return games.length;
	}
	
	public AvailableGame getAvailableGame(int index) {
		return games[index];
	}
	
	public AvailableGame getAvailableGame(String roomId) {
		if (roomId != null) {					
			for (AvailableGame game : games) {
				if (roomId.equals(game.getRoomId())) {
					return game;
				}
			}
		}
		return null;
	}
	
}
