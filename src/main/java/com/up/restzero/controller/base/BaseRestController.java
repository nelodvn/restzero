package com.up.restzero.controller.base;

public class BaseRestController {
	

	public JsonResponse success(Object payload){	
		return success(payload, null);
	}
	
	public JsonResponse success(String message){	
		return success(null, message);
	}

	public JsonResponse success(Object payload, String message){
		return new JsonResponse(HttpStatus.SUCCESS, message, payload);
	}

	public JsonResponse error(Object payload){
	 	return error(payload, null);
	 }
	
	public JsonResponse error(String message){
	 	return error(null, message);
	 }

	 public JsonResponse error(Object payload, String message){
		 return new JsonResponse(HttpStatus.ERROR, message, payload);
	 }
}
