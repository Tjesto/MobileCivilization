package com.example.mobilecivilisation.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public final class EntryPointActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		startActivity(chooseEntryPoint());
		finish();
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
	
}
