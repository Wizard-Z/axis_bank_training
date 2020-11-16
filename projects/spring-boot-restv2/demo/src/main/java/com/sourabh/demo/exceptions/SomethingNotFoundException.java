package com.sourabh.demo.exceptions;

public class SomethingNotFoundException extends RuntimeException {

    public SomethingNotFoundException(String message){
        super(message);
    }
}
