package com.example.mobilecivilisation.ui.activities.impl;

import com.example.mobilecivilisation.R;
import com.example.mobilecivilisation.network.Caller;
import com.example.mobilecivilisation.network.jobs.GetAvailableGamesJob;
import com.example.mobilecivilisation.utils.HardwareInfo;
import com.mobciv.datamodel.AbstractResponse;
import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.reponses.GetAvailableGamesResponse;
import com.mobciv.protocol.requests.GetAvailableGamesRequest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainScreenActivityImpl implements ActivityImpl, Caller {

	private final Activity activity;

	public MainScreenActivityImpl(Activity activity) {
		this.activity = activity;
	}
	
	@Override
	public void onResume() {
		new GetAvailableGamesJob(this, new GetAvailableGamesRequest(
				HardwareInfo.getId(activity))).execute();
	}


	@Override
	public void responseArrived(JsonSerializable response) {	
		Log.i(activity.getClass().getName(), "Response received -> " + ((AbstractResponse) response).getPacketId());
		if (!(response instanceof GetAvailableGamesResponse)) {
			return;
		}
		GetAvailableGamesResponse concreteResponse = (GetAvailableGamesResponse) response;
		if (concreteResponse.getGames() != null && concreteResponse.getGames().getAvailableGamesCount() > 0) {
			//create adapter for game rooms
		} else {
			//add one element list with "No rooms available" title
			Toast.makeText(activity, "No rooms available", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		activity.setContentView(R.layout.main_screen);
		
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		
	}

}
