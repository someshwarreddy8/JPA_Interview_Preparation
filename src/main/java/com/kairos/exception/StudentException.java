package com.kairos.exception;

import lombok.Data;

@Data
public class StudentException extends RuntimeException {
    private String statusCode;

    public StudentException(String statusCode, Throwable message) {
        super(statusCode, message);

        this.statusCode = statusCode;
    }

    public StudentException() {

    }
}
