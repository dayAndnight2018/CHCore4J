package com.chenghua.exceptions;

public class InValidConstructorArgs extends Exception{
	
	public InValidConstructorArgs()
	{
		super("The args of the constructor function is invalid.");
	}
	
	public InValidConstructorArgs(String message)
	{
		super(message);
	}
}
