package dev.patika.creditapplication.exceptions;
// Implementation of Exception
public class CustomerIsAlreadyExistException extends RuntimeException{

    public CustomerIsAlreadyExistException(String message) {
        super(message);
    }

}