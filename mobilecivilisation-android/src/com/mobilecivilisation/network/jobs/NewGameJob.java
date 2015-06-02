package com.mobilecivilisation.network.jobs;

import com.mobciv.protocol.reponses.NewGameResponse;
import com.mobciv.protocol.requests.NewGameRequest;
import com.mobilecivilisation.network.Caller;

public class NewGameJob extends AbstractJob {

	private final NewGameRequest reqest;

	public NewGameJob(Caller caller, NewGameRequest request) {
		super(caller, NewGameResponse.class);
		this.reqest = request;
	}

	@Override
	public void execute() {
		executor.execute(reqest);
	}

}
