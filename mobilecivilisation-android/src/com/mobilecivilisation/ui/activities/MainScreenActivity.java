package com.mobilecivilisation.ui.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

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

public class MainScreenActivity extends AppCompatActivity implements Caller, NewGameDialogHelper.DialogClosed{

private Toolbar toolbar;
private ActivityImpl impl;
private Intent newGameIntent;
	
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
			NewGameDialogHelper dialog = new NewGameDialogHelper(this);
			dialog.setListener(this);
			dialog.show();										
			break;
		case R.id.settings:
			startActivity(new Intent(this, SettingsMenuActivity.class));
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		
		return true;
		
	}

	@Override
	public void responseArrived(JsonSerializable response) {
		if (response instanceof NewGameResponse && newGameIntent != null) {
			Log.d(this.getClass().getName(), "Game created");
			new JoinGameJob((Caller) this, new JoinGameRequest(HardwareInfo.getId(this), newGameIntent.getIntExtra(Keys.CIVILISATION_ID, -1), newGameIntent.getStringExtra(Keys.NEW_ROOM_TITLE))).execute();
			return;
		}
		if (response instanceof JoinGameResponse) {
			Log.d(this.getClass().getName(), "Game joined");
			startActivity(newGameIntent);
			return;
		}
	}

	@Override
	public void onDialogFinished(NewGameDialogHelper dialog) {
		newGameIntent = dialog.getIntent(MainGameActivity.class);
		new NewGameJob(this, new NewGameRequest(HardwareInfo.getId(this), newGameIntent.getStringExtra(Keys.NEW_ROOM_TITLE))).execute();
		
	}
	
}
