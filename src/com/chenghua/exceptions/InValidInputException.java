package com.chenghua.exceptions;

@SuppressWarnings("serial")
public class InValidInputException extends Exception{
	
	public InValidInputException()
	{
		super("Invalid input arguments!");
	}
	
	public InValidInputException(String message)
	{
		super(message);
	}
}
