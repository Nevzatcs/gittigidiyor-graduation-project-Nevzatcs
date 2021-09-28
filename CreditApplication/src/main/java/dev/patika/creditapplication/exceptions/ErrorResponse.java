package dev.patika.creditapplication.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Error Response Implementation for When Exception Throw
public class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}