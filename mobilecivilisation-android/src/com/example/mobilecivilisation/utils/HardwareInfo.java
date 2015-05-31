package com.example.mobilecivilisation.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

public final class HardwareInfo {

	public static String getId(Context context) {
		TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);		
		return manager.getDeviceId();
	}

	
}
