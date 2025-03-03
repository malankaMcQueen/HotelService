package org.example.hotelsinfo.exception;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(final String msg) {
        super(msg);
    }

}
