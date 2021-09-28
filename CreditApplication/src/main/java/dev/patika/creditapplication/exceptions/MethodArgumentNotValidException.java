package dev.patika.creditapplication.exceptions;
// Implementation of Exception to Invalid input according to pattern at CustomerDTO
public class MethodArgumentNotValidException extends RuntimeException{
    public MethodArgumentNotValidException(String message) {
        super(message);
    }
}

