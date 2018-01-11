package com.sprinthive.starter.cqrs.read.dob;

public class DobNotFoundException extends RuntimeException {

    public DobNotFoundException(String message) {
        super(message);
    }
}
