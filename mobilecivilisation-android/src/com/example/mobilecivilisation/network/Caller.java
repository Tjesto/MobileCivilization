package com.example.mobilecivilisation.network;

import com.mobciv.datamodel.JsonSerializable;

public interface Caller {
	void responseArrived(JsonSerializable response);
}
