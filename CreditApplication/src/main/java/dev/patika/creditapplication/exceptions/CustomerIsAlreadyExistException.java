package dev.patika.creditapplication.exceptions;

public class CustomerIsAlreadyExistException extends RuntimeException{

    public CustomerIsAlreadyExistException(String message) {
        super(message);
    }



}