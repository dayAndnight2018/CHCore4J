package com.chenghua.exceptions;

public class InvalidInputException extends Exception{
	
	public InvalidInputException() {
		super("Invalid input arguments!");
	}
	
	public InvalidInputException(String message) {
		super(message);
	}
}
