package com.sourabh.bookingservice.exceptions;

public class SomethingNotFoundException extends RuntimeException {

    public SomethingNotFoundException(String message){
        super(message);
    }
}
