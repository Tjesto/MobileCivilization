package com.mobilecivilisation.network.jobs;

import com.mobciv.protocol.reponses.HandshakeResponse;
import com.mobciv.protocol.requests.HandshakeRequest;
import com.mobilecivilisation.network.Caller;

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
