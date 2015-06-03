package com.mobilecivilisation.network.jobs;

import com.mobciv.protocol.reponses.JoinGameResponse;
import com.mobciv.protocol.requests.JoinGameRequest;
import com.mobilecivilisation.network.Caller;

public class JoinGameJob extends AbstractJob {

	private final JoinGameRequest reqest;

	public JoinGameJob(Caller caller, JoinGameRequest request) {
		super(caller, JoinGameResponse.class);
		this.reqest = request;
	}
	
	@Override
	public void execute() {
		executor.execute(reqest);
	}

}
