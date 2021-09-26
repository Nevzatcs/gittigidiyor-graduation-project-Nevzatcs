package dev.patika.creditapplication.exceptions;

public class IdentityNumberNotFoundException  extends RuntimeException {

    public IdentityNumberNotFoundException(String message) {
        super(message);
    }

}