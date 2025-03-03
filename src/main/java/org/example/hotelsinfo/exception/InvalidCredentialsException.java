package org.example.hotelsinfo.exception;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(final String msg) {
        super(msg);
    }
}
