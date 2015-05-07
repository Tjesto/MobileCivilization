package com.mobciv.datamodel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class JsonSerializer {

	public static String toJson(JsonSerializable chunk) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(chunk);
	}
	
	@SuppressWarnings("unchecked")
	public static JsonSerializable fromJson(String json, Class<?> handledRequest) {
		Gson gson = new GsonBuilder().create();
		return (JsonSerializable) gson.fromJson(json, handledRequest);
	}
	
}
