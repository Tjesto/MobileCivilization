package com.example.mobilecivilisation.network.jobs;

import com.example.mobilecivilisation.network.Caller;
import com.mobciv.protocol.reponses.GetAvailableGamesResponse;
import com.mobciv.protocol.requests.GetAvailableGamesRequest;

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
