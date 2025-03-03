package org.example.hotelsinfo.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(final String msg) {
        super(msg);
    }

}
