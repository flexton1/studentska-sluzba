package com.example.take.home.page.exception;

public class SpringStudentException extends RuntimeException {
    public SpringStudentException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringStudentException(String exMessage) {
        super(exMessage);
    }
}
