package com.edu.work.comfortbus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = Logger.getLogger(ExceptionControllerAdvice.class.getName());

    @ExceptionHandler(value = SystemException.class)
    public ResponseEntity<ErrorDTO> handleSystemException(final SystemException e) {
        LOGGER.log(Level.SEVERE, "SystemException", e);
        return new ResponseEntity<>(new ErrorDTO(e), HttpStatus.valueOf(e.getErrorCode().getHttpStatusCode()));
    }

}
