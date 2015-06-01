package com.example.mobilecivilisation.network.jobs;

import com.example.mobilecivilisation.network.Caller;
import com.mobciv.protocol.reponses.HandshakeResponse;
import com.mobciv.protocol.requests.HandshakeRequest;

public class HandshakeJob extends AbstractJob {
		
	private final HandshakeRequest request;
	public HandshakeJob(Caller caller, HandshakeRequest request) {
		super(caller, HandshakeResponse.class);
		this.request = request;
		
	}

	public void execute() {		
		/*Intent service = new Intent(activity, JobExecutionService.class);		
		service.putExtra(JobNames.REQUEST, JsonSerializer.toJson(request));
		activity.startService(service);*/
		executor.execute(request);
	}

}
