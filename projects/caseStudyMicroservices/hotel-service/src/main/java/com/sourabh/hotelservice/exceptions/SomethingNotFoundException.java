package com.sourabh.hotelservice.exceptions;

public class SomethingNotFoundException extends RuntimeException {

    public SomethingNotFoundException(String message){
        super(message);
    }
}
