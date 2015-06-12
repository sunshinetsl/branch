package com.dragon.common.util;

public class CustomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3634418028123337197L;

	public CustomException(){
		
	}
	
	public CustomException(String msg) throws CustomException{
		super(msg);
	}
}
