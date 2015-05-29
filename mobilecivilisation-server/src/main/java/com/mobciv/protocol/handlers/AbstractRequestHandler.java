package com.mobciv.protocol.handlers;

import com.mobciv.datamodel.ErrorTypes;
import com.mobciv.datamodel.JsonSerializable;
import com.mobciv.datamodel.JsonSerializer;
import com.mobciv.protocol.reponses.ErrorResponse;

public abstract class AbstractRequestHandler {
	
	protected AbstractRequestHandler next;
	private final Class<?> handledRequest;
	protected final String requestId;
	
	public AbstractRequestHandler(Class<?> handledRequest, int requestId) {
		this.handledRequest = handledRequest;
		this.requestId = Integer.toString(requestId);
	}

	protected boolean filterRequest(String request) {
		return request.replaceAll("[\\[\\]\\{\\}]", "").contains(this.getRequestId());
				
	}
	
	private String getRequestId() {		
		return "\"requestId\":" + requestId;
	}

	protected JsonSerializable pushRequest(String request) {		
		if (next != null) {
			return next.handleRequest(request);
		}		
		return new ErrorResponse(ErrorTypes.REQ_NOT_HANDLED);
	}
	
	public void add(AbstractRequestHandler newHandler) {
		if (next == null) {
			this.next = newHandler;
		} else {
			next.add(newHandler);
		}
	}
	
	protected JsonSerializable getRequest(String request) {
		return JsonSerializer.fromJson(request, handledRequest);
	}
	
	public abstract JsonSerializable handleRequest(String request);
}
