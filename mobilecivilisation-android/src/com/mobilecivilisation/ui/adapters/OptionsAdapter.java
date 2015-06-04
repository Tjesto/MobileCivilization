package com.mobilecivilisation.ui.adapters;

import java.util.List;

import com.mobilecivilisation.R;
import com.mobilecivilisation.misc.Option;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class OptionsAdapter extends ArrayAdapter<Option> {

	public OptionsAdapter(Context context, int resource, List<Option> objects) {
		super(context, resource, objects);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView v = (TextView) View.inflate(getContext(), R.layout.settings_item, null);
		Option o = getItem(position);
		v.setText(o.getTitleId());
		return v;
	}
}
