package com.mobilecivilisation.network.jobs;

import com.mobilecivilisation.network.Caller;
import com.mobilecivilisation.network.JobExecutor;
import com.mobciv.datamodel.AbstractResponse;
import com.mobciv.datamodel.JsonSerializable;

public abstract class AbstractJob {
	
	protected JobExecutor executor;
	
	public AbstractJob(Caller caller, Class<? extends AbstractResponse> responseClass) {
		executor = new JobExecutor(responseClass,
				caller != null ? caller : new Caller() {

					@Override
					public void responseArrived(JsonSerializable response) {
						// do nothing
					}
				});
	}
	
	
	public abstract void execute();
}
