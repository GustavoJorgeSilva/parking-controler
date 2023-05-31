package com.api.parkingregistration.services.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(String msg){
        super(msg);
    }

}
