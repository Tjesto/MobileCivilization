package com.mobilecivilisation.ui.activities;

import com.mobciv.datamodel.AbstractResponse;
import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.requests.HandshakeRequest;
import com.mobilecivilisation.network.Caller;
import com.mobilecivilisation.network.jobs.HandshakeJob;
import com.mobilecivilisation.utils.HardwareInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public final class EntryPointActivity extends Activity implements Caller {

	private HandshakeJob job;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		job = new HandshakeJob(this, new HandshakeRequest(HardwareInfo.getId(this)));
		job.execute();
	}

	private Intent chooseEntryPoint() {
		Class<?> activityClass;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			activityClass = MainScreenActivityL.class;
		} else {
			activityClass = MainScreenActivity.class;
		}
		return new Intent(this, activityClass);
	}

	@Override
	public void responseArrived(JsonSerializable response) {
		Log.i(EntryPointActivity.class.getName(), "Response received -> " + ((AbstractResponse) response).getPacketId());
		startActivity(chooseEntryPoint());
		finish();
	}
	
}
