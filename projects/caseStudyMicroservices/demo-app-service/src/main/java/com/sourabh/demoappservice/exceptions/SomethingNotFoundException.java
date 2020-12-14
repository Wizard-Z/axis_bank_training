package com.sourabh.demoappservice.exceptions;

public class SomethingNotFoundException extends RuntimeException {

    public SomethingNotFoundException(String message){
        super(message);
    }
}
