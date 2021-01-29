package com.lp.work.comfortbus.exception.code;

import org.springframework.http.HttpStatus;

public enum ServiceErrorCode implements ErrorCode {

    BAD_REQUEST(400, HttpStatus.BAD_REQUEST.value());

    private final int errorCode;
    private final int httpStatus;

    ServiceErrorCode(final int errorCode, final int httpStatusCode) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatusCode;
    }

    @Override
    public int getHttpStatusCode() {
        return httpStatus;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }
}
