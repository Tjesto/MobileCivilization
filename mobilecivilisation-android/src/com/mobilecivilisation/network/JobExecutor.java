package com.mobilecivilisation.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.datamodel.JsonSerializer;
import com.mobilecivilisation.utils.Config;

import android.os.AsyncTask;
import android.util.Log;

public class JobExecutor extends AsyncTask<JsonSerializable, Void, JsonSerializable> {

	private Class<?> responseType;
	private Caller caller;
	
	public JobExecutor(Class<?> responseType, Caller caller) {
		this.responseType = responseType;
		this.caller = caller;
	}
	
	@Override
	protected JsonSerializable doInBackground(JsonSerializable... params) {
		try {
			@SuppressWarnings("resource")
			Socket clientSocket = new Socket(Config.HOST_ADDRESS, Config.HOST_PORT);
			PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			JsonSerializable request = params[0];
			String requestString = JsonSerializer.toJson(request); 
			pw.println(requestString);	
			String responseString = reader.readLine();
			Log.d(JobExecutor.class.getName(), responseString);
			JsonSerializable response = JsonSerializer.fromJson(responseString, responseType);			
			return response;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(JsonSerializable result) {		
		super.onPostExecute(result);
		caller.responseArrived(result);
	}

}
