package com.example.rabbitmqapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public abstract class AbstractException extends RuntimeException {

    private final String title;
    private final HttpStatus status;

    public AbstractException(String message, String title, HttpStatus status) {
        super(message);
        this.title = title;
        this.status = status;
    }

    public AbstractException(String message, Throwable cause, String title, HttpStatus status) {
        super(message, cause);
        this.title = title;
        this.status = status;
    }

    public AbstractException(Throwable cause, String title, HttpStatus status) {
        super(cause);
        this.title = title;
        this.status = status;
    }

    protected AbstractException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace, String title, HttpStatus status) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.title = title;
        this.status = status;
    }
}
