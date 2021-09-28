package dev.patika.creditapplication.exceptions;
// Implementation of Exception for Customer which is not found
public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
