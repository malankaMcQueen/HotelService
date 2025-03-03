package org.example.hotelsinfo.exception;

public class TokenExpiredException extends RuntimeException {
    public TokenExpiredException(final String msg) {
        super(msg);
    }
}

