package com.mobilecivilisation.network.jobs;

import com.mobciv.protocol.reponses.GetAvailableGamesResponse;
import com.mobciv.protocol.requests.GetAvailableGamesRequest;
import com.mobilecivilisation.network.Caller;

public class GetAvailableGamesJob extends AbstractJob {

	
	
	private final GetAvailableGamesRequest request;

	public GetAvailableGamesJob(Caller caller,
			GetAvailableGamesRequest request) {
		super(caller, GetAvailableGamesResponse.class);
		this.request = request;
	}

	@Override
	public void execute() {
		executor.execute(request);
	}

}
