package com.mobilecivilisation.ui.activities.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public interface ActivityImpl {
	
	void onResume();
	
	void onCreate(Bundle savedInstanceState);
	
	void onPause();			

}
