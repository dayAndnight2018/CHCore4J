package com.chenghua.exceptions;

public class AssertClassNotMatchException extends Exception{

    public AssertClassNotMatchException(){
        super("The assert input parameters mismatch in class.");
    }

    public AssertClassNotMatchException(String message){
        super(message);
    }
}
