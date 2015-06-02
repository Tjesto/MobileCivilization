package com.example.mobilecivilisation.ui.activities;

import java.util.ArrayList;
import java.util.List;

import com.example.mobilecivilisation.R;
import com.example.mobilecivilisation.misc.Option;
import com.example.mobilecivilisation.ui.adapters.OptionsAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SettingsMenuActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_screen);
		final OptionsAdapter adapter = new OptionsAdapter(this, R.layout.settings_item, createOptions());
		((ListView) findViewById(R.id.settings_options)).setAdapter(adapter);
		setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
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
				startActivity(new Intent(SettingsMenuActivity.this, DebugMenuActivity.class));
			}
		}));
		return res;
	}
}
