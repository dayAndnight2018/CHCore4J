package com.chenghua.exceptions;

public class InvalidConstructorArgs extends Exception{
	
	public InvalidConstructorArgs() {
		super("The args of the constructor function is invalid.");
	}
	
	public InvalidConstructorArgs(String message) {
		super(message);
	}
}
