package dev.patika.creditapplication.exceptions;
// Implementation of Exception for IdentityNumber which is not exist
public class IdentityNumberNotFoundException  extends RuntimeException {
    public IdentityNumberNotFoundException(String message) {
        super(message);
    }

}