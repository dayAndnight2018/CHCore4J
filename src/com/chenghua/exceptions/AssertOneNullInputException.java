package com.chenghua.exceptions;

public class AssertOneNullInputException extends Exception{

    public AssertOneNullInputException(){
        super("The assert has one null input.");
    }

    public AssertOneNullInputException(String message){
        super(message);
    }
}
