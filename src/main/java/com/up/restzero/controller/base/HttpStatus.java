package com.up.restzero.controller.base;

public enum HttpStatus {
	SUCCESS("success", 200), 
	ERROR("error", 500);
	// implementar os demais status necessarios :) isto e' somente um exemplo
	
	private String status;
	private int statusCode;
	
	HttpStatus(String status, int statusCode) {
		this.status = status;
		this.statusCode = statusCode;
	}
	
	public int getStatusCode(){
		return this.statusCode;
	}
	
	public String getStatus(){
		return this.status;
	}
}
