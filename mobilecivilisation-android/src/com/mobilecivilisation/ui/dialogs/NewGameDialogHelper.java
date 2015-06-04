package com.mobilecivilisation.ui.dialogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.EditText;

import com.mobciv.protocol.objects.Civilisations;
import com.mobilecivilisation.R;
import com.mobilecivilisation.ui.util.Keys;

public class NewGameDialogHelper {
	
	public interface DialogClosed{
		void onDialogFinished(NewGameDialogHelper dialog);
	}
	
	private final Context context;	
	private boolean result;
	private Intent startIntent;
	private DialogClosed listener;	
	
	public NewGameDialogHelper(Context context) {
		this.context = context;
	}
	
	public boolean show() {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		final EditText input = new EditText(context);
		builder.setView(input);
		builder.setTitle(R.string.new_game_dialog_title);
		builder.setCancelable(true);
		builder.setOnCancelListener(new OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				dialog.dismiss();
				result = false;
			}
		});
		builder.setPositiveButton(R.string.new_game_dialog_proceed, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {					
				dialog.dismiss();					
				showCivilisationChooser(input.getText().toString());
			}
		});
		builder.setNegativeButton(R.string.abort, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				result = false;
			}
		}).show();
		return result;
	}

	protected void showCivilisationChooser(final String text) {
		if (text == null) {
			result = false;
			return;
		}
		final List<Civilisations> selected = new ArrayList<Civilisations>(1);
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(R.string.civilisation_chooser_dialog_title);
		List<String> civilisations = new ArrayList<String>();
		for (Civilisations c : Civilisations.values()) {
			if (c != Civilisations.BARBARIANS) {
				civilisations.add(c.name());
			}
		}
		String[] civStrings = new String[civilisations.size()];
		civStrings = civilisations.toArray(civStrings);
		builder.setSingleChoiceItems(civStrings, 0, null);	
		builder.setCancelable(true);
		builder.setOnCancelListener(new OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				dialog.dismiss();
				result = false;
			}
		});		
		builder.setPositiveButton(R.string.new_game_dialog_proceed, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {					
				dialog.dismiss();
				createInitialIntent(text, Civilisations.values()[((AlertDialog)dialog).getListView().getCheckedItemPosition()].getCivilisationId());
				if (listener != null) {
					listener.onDialogFinished(NewGameDialogHelper.this);
				}
			}
		});
		builder.setNegativeButton(R.string.abort, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				result = false;
			}
		}).show();
				
	}
	
	private void createInitialIntent(String text, int civilisationId) {
		startIntent = new Intent();
		startIntent.putExtra(Keys.NEW_ROOM_TITLE, text);
		startIntent.putExtra(Keys.CIVILISATION_ID, civilisationId);
	}
	
	public Intent getIntent(Class<?> nextActivity) {
		Intent start = new Intent(context, nextActivity);
		start.fillIn(startIntent, 0);
		return start;
	}

	public void setListener(DialogClosed listener) {
		this.listener = listener;
	}
}
