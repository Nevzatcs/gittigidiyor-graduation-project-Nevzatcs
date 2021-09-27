package dev.patika.creditapplication.exceptions;

public class TransactionDateTimeParseException extends RuntimeException{
    public TransactionDateTimeParseException(String msg) {
        super(msg);
    }
}
