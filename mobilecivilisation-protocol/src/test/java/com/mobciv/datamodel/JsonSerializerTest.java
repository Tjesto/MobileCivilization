package com.mobciv.datamodel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mobciv.protocol.requests.HandshakeRequest;

public class JsonSerializerTest {

	private HandshakeRequest message;
	
	@Before
	public void setUp() throws Exception {
		message = new HandshakeRequest("test", 0x20);
	}

	@Test
	public void testToJson() {
		String result = JsonSerializer.toJson(message);
		System.out.println(result);
	}

	@Test
	public void testFromJson() {
		String result = JsonSerializer.toJson(message);
		HandshakeRequest m2 = (HandshakeRequest) JsonSerializer.fromJson(result, HandshakeRequest.class);
		assertEquals(message, m2);
	}

}
