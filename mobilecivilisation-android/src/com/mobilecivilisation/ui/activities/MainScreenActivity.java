package com.mobilecivilisation.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mobilecivilisation.ui.activities.impl.ActivityImpl;
import com.mobilecivilisation.ui.activities.impl.MainScreenActivityImpl;
import com.mobilecivilisation.R;

public class MainScreenActivity extends AppCompatActivity {

private Toolbar toolbar;
private ActivityImpl impl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		impl = new MainScreenActivityImpl(this);
		impl.onCreate(savedInstanceState);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		impl.onResume();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menus, menu);
	    return true;	    
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		switch (itemId) {
		case R.id.new_game:
			startActivity(new Intent(this, MainGameActivity.class));
			break;
		case R.id.settings:
			startActivity(new Intent(this, SettingsMenuActivity.class));
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		
		return true;
		
	}
	
}
