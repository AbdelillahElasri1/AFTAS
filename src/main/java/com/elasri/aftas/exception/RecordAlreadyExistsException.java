package com.elasri.aftas.exception;

public class RecordAlreadyExistsException extends RuntimeException{
    public RecordAlreadyExistsException(String message){
        super(message);
    }
}
