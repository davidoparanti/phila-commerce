package com.decagon.phila.exceptions;

public class InvalidPageOrSizeException extends RuntimeException{
    public InvalidPageOrSizeException(String message) {
        super(message);
    }
}
