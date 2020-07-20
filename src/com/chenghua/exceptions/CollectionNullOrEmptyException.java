package com.chenghua.exceptions;

public class CollectionNullOrEmptyException extends Exception{

    public CollectionNullOrEmptyException(){
        super("The collection is null or empty");
    }

    public CollectionNullOrEmptyException(String message){
        super(message);
    }

}
