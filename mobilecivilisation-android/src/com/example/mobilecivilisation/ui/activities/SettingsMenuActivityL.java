package com.example.mobilecivilisation.ui.activities;

import java.util.ArrayList;
import java.util.List;

import com.example.mobilecivilisation.R;
import com.example.mobilecivilisation.misc.Option;
import com.example.mobilecivilisation.ui.adapters.OptionsAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class SettingsMenuActivityL extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_screen);
		OptionsAdapter adapter = new OptionsAdapter(this, R.layout.settings_item, createOptions());
		((ListView) findViewById(R.id.settings_options)).setAdapter(adapter);
	}

	private List<Option> createOptions() {
		List<Option> res = new ArrayList<Option>();
		res.add(new Option(0, R.string.debug));
		return res;
	}
}
