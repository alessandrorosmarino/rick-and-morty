package com.bcnc.rick.morty.consumer.exception;

public class NoRMCharacterFoundException extends RuntimeException{

    public NoRMCharacterFoundException(String message) {
        super(message);
    }
}
