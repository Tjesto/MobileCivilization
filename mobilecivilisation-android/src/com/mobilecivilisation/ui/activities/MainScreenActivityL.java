package com.mobilecivilisation.ui.activities;

import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.reponses.JoinGameResponse;
import com.mobciv.protocol.reponses.NewGameResponse;
import com.mobciv.protocol.requests.JoinGameRequest;
import com.mobciv.protocol.requests.NewGameRequest;
import com.mobilecivilisation.network.Caller;
import com.mobilecivilisation.network.jobs.JoinGameJob;
import com.mobilecivilisation.network.jobs.NewGameJob;
import com.mobilecivilisation.ui.activities.impl.ActivityImpl;
import com.mobilecivilisation.ui.activities.impl.MainScreenActivityImpl;
import com.mobilecivilisation.ui.dialogs.NewGameDialogHelper;
import com.mobilecivilisation.ui.util.Keys;
import com.mobilecivilisation.utils.HardwareInfo;
import com.mobilecivilisation.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MainScreenActivityL extends Activity implements Caller, NewGameDialogHelper.DialogClosed {
	
	private Toolbar toolbar;
	private ActivityImpl impl;
	private Intent newGameIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		impl = new MainScreenActivityImpl(this);
		impl.onCreate(savedInstanceState);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setActionBar(toolbar);
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
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		int itemId = item.getItemId();
		switch (itemId) {
		case R.id.new_game:
			NewGameDialogHelper dialog = new NewGameDialogHelper(this);
			Log.d("log_for_ms", "clicked " + dialog);
			dialog.setListener(this);
			dialog.show();
			break;
		case R.id.settings:
			startActivity(new Intent(this, SettingsMenuActivityL.class));
			break;
		default:
			return super.onMenuItemSelected(featureId, item);
		}
		
		return true;
		
	}
	
	public void onDialogFinished(NewGameDialogHelper dialog) {
		Log.d("log_for_ms", "onDialogFinished " + dialog);
		newGameIntent = dialog.getIntent(MainGameActivity.class);
		new NewGameJob(this, new NewGameRequest(HardwareInfo.getId(this), newGameIntent.getStringExtra(Keys.NEW_ROOM_TITLE))).execute();
	}
	
	@Override
	public void responseArrived(JsonSerializable response) {
		if (response instanceof NewGameResponse && newGameIntent != null) {
			Log.d(this.getClass().getName(), "Game created");
			Log.d("log_for_ms", "created");
			new JoinGameJob((Caller) this, new JoinGameRequest(HardwareInfo.getId(this), newGameIntent.getIntExtra(Keys.CIVILISATION_ID, -1), newGameIntent.getStringExtra(Keys.NEW_ROOM_TITLE))).execute();
			return;
		}
		if (response instanceof JoinGameResponse) {
			Log.d(this.getClass().getName(), "Game joined");
			Log.d("log_for_ms", "joined");
			startActivity(newGameIntent);
			return;
		}
	}
	
}
