package com.mobciv.datamodel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class JsonSerializer {

	public static String toJson(JsonSerializable chunk) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(chunk);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends JsonSerializable> T fromJson(String json, Class<?> handledRequest) {
		Gson gson = new GsonBuilder().create();
		return (T) gson.fromJson(json, handledRequest);
	}
	
}
