package com.lp.work.comfortbus.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lp.work.comfortbus.exception.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private LocalDateTime date;

    private ErrorCode errorCode;

    private String message;

    private String stackTrace;


    public ErrorDTO(final SystemException e) {
        this((Exception) e);
        this.errorCode = e.getErrorCode();
    }

    public ErrorDTO(final Exception exception) {
        this.date = LocalDateTime.now();
        this.message = exception == null ? null : exception.getMessage();
        this.stackTrace = exception == null ? null : Arrays.toString(exception.getStackTrace());
    }
}
