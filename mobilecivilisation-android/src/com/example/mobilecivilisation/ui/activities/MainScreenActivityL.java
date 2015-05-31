package com.example.mobilecivilisation.ui.activities;

import com.example.mobilecivilisation.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menus, menu);
	    return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		int itemId = item.getItemId();
		switch (itemId) {
		case R.id.new_game:
			startActivity(new Intent(this, MainGameActivity.class));
			break;
		case R.id.help:
			startActivity(new Intent(this, SettingsMenuActivityL.class));
			break;
		default:
			return super.onMenuItemSelected(featureId, item);
		}
		
		return true;
		
	}
	
}
