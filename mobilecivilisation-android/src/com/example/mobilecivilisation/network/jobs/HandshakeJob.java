package com.example.mobilecivilisation.network.jobs;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.mobilecivilisation.network.Caller;
import com.example.mobilecivilisation.network.JobExecutor;
import com.example.mobilecivilisation.network.services.JobExecutionService;
import com.example.mobilecivilisation.network.utils.JobNames;
import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.datamodel.JsonSerializer;
import com.mobciv.protocol.reponses.HandshakeResponse;
import com.mobciv.protocol.requests.HandshakeRequest;

public class HandshakeJob implements AbstractJob {
	
	private final Activity activity;
	private final HandshakeRequest request;
	private JobExecutor executor;

	public HandshakeJob(Activity activity, HandshakeRequest request) {
		this.activity = activity;
		this.request = request;
		executor = new JobExecutor(HandshakeResponse.class,
				activity instanceof Caller ? (Caller) activity : new Caller() {

					@Override
					public void responseArrived(JsonSerializable response) {
						// do nothing
					}
				});
	}

	public void execute() {		
		/*Intent service = new Intent(activity, JobExecutionService.class);		
		service.putExtra(JobNames.REQUEST, JsonSerializer.toJson(request));
		activity.startService(service);*/
		executor.execute(request);
	}

}
