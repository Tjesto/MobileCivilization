package com.example.mobilecivilisation.ui.activities;

import com.example.mobilecivilisation.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toolbar;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MainScreenActivityL extends Activity {
	
	private Toolbar toolbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);	
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setActionBar(toolbar);
	}

}
