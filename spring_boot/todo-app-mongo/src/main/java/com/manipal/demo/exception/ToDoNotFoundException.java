package com.manipal.demo.exception;

public class ToDoNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ToDoNotFoundException(String message) {
		super(message);
	}
	

}
