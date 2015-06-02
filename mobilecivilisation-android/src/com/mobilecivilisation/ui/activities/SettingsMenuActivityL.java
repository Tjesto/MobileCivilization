package com.mobilecivilisation.ui.activities;

import java.util.ArrayList;
import java.util.List;

import com.mobilecivilisation.R;
import com.mobilecivilisation.misc.Option;
import com.mobilecivilisation.ui.adapters.OptionsAdapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toolbar;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class SettingsMenuActivityL extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_screen);
		final OptionsAdapter adapter = new OptionsAdapter(this, R.layout.settings_item, createOptions());
		((ListView) findViewById(R.id.settings_options)).setAdapter(adapter);
		setActionBar((Toolbar) findViewById(R.id.toolbar));
		((ListView) findViewById(R.id.settings_options)).setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				adapter.getItem(position).onClick();
			}
			
		});
	}

	private List<Option> createOptions() {
		List<Option> res = new ArrayList<Option>();
		res.add(new Option(0, R.string.debug, new Runnable() {
			
			@Override
			public void run() {
				startActivity(new Intent(SettingsMenuActivityL.this, DebugMenuActivity.class));
			}
		}));
		return res;
	}
}
