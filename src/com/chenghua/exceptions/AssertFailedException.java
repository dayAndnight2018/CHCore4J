package com.chenghua.exceptions;

public class AssertFailedException extends Exception{

    public AssertFailedException(){
        super("Assert failed.");
    }

    public AssertFailedException(String message){
        super(message);
    }
}