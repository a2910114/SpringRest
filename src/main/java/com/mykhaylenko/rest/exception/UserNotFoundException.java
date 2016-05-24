package com.mykhaylenko.rest.exception;

/**
 * Created by Pavlo.Mykhaylenko on 5/10/2016.
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
