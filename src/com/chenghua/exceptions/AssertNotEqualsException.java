package com.chenghua.exceptions;

public class AssertNotEqualsException extends Exception{

    public AssertNotEqualsException(){
        super("Assert inputs are not equals.");
    }

    public AssertNotEqualsException(String message){
        super(message);
    }
}
