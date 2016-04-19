package com.up.restzero.controller.base;

public class JsonResponse {
	private int httpStatus;
	private String status;
	private String message;
	private Object payload;

	public JsonResponse(HttpStatus httpResponseStatus) {
		this.status = httpResponseStatus.getStatus();
		this.httpStatus = httpResponseStatus.getStatusCode();
	}

	public JsonResponse(HttpStatus httpResponseStatus, String message) {
		this.status = httpResponseStatus.getStatus();
		this.httpStatus = httpResponseStatus.getStatusCode();
		this.message = message;
	}

	public JsonResponse(HttpStatus httpResponseStatus, String message, Object payload) {
		this.status = httpResponseStatus.getStatus();
		this.httpStatus = httpResponseStatus.getStatusCode();
		this.message = message;
		this.payload = payload;
	}

	public String getStatus() {
		return status;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public Object getPayload() {
		return payload;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public void setPayload(Object data) {
		this.payload = data;
	}
}
