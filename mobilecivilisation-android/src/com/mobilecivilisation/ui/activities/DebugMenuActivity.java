package com.mobilecivilisation.ui.activities;

import java.util.ArrayList;
import java.util.List;

import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.protocol.reponses.HandshakeResponse;
import com.mobciv.protocol.requests.GetAvailableGamesRequest;
import com.mobciv.protocol.requests.HandshakeRequest;
import com.mobciv.protocol.requests.NewGameRequest;
import com.mobilecivilisation.R;
import com.mobilecivilisation.misc.Option;
import com.mobilecivilisation.network.Caller;
import com.mobilecivilisation.network.jobs.AbstractJob;
import com.mobilecivilisation.network.jobs.GetAvailableGamesJob;
import com.mobilecivilisation.network.jobs.HandshakeJob;
import com.mobilecivilisation.network.jobs.NewGameJob;
import com.mobilecivilisation.ui.adapters.OptionsAdapter;
import com.mobilecivilisation.utils.HardwareInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DebugMenuActivity extends Activity implements Caller {

	private List<Option> items;
	private AbstractJob job;
	private DebugMenuActivity context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.debug_menu);
		items = new ArrayList<Option>();
		context = DebugMenuActivity.this;
		addItems();
		final OptionsAdapter adapter = new OptionsAdapter(this, R.layout.settings_item, items);	
		((ListView) findViewById(R.id.setting_options)).setAdapter(adapter);
		((ListView) findViewById(R.id.setting_options)).setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				adapter.getItem(position).onClick();
			}
			
		});
	}

	private void addItems() {
		items.add(new Option(0, R.string.debug_handshake, new Runnable() {
			
			@Override
			public void run() {
				job = new HandshakeJob(context, new HandshakeRequest(HardwareInfo.getId(context)));
				job.execute();
			}
		}));
		items.add(new Option(0, R.string.debug_get_games, new Runnable() {
			
			@Override
			public void run() {
				job = new GetAvailableGamesJob(context, new GetAvailableGamesRequest(HardwareInfo.getId(context)));				
				job.execute();
			}
		}));
		items.add(new Option(0, R.string.debug_newgame, new Runnable() {
			
			@Override
			public void run() {
				job = new NewGameJob(context, new NewGameRequest(HardwareInfo.getId(context), "Test room"));
				job.execute();
			}
		}));
	}

	@Override
	public void responseArrived(JsonSerializable response) {		
		Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show();
	}
}
