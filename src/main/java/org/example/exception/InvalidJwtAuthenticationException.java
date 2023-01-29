package org.example.exception;

public class InvalidJwtAuthenticationException extends Exception {
    public InvalidJwtAuthenticationException(String message) {
        super(message);
    }
}