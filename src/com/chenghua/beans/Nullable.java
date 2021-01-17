package com.chenghua.beans;

import java.util.function.Predicate;

public class Nullable<T> {

    private T data;

    public Nullable(T data) {
        this.data = data;
    }

    public static <U> Nullable<U> of(U data) {
        return new Nullable<U>(data);
    }

    public boolean hasValue() {
        return data != null;
    }

    public T getValue() {
        return data;
    }

    public T getOrDefault(T data){
        if(hasValue()){
            return this.data;
        }
        return data;
    }

    public T getOrDefault(Predicate<T> predicate, T data){
        if(hasValue() && predicate.test(this.data)){
            return this.data;
        }
        return data;
    }

    public void setValue(T data) {
        this.data = data;
    }
}
