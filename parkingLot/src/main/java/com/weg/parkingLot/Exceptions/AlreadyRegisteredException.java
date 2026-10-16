package com.weg.parkingLot.Exceptions;

public class AlreadyRegisteredException extends RuntimeException{

    public AlreadyRegisteredException (String message){
        super(message);
    }
}
