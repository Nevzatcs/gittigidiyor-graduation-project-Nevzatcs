package dev.patika.creditapplication.exceptions;
// Implementation of Exception, if TransactionDate writes wrong
public class TransactionDateTimeParseException extends RuntimeException{
    public TransactionDateTimeParseException(String msg) {
        super(msg);
    }
}
