package com.edu.work.comfortbus.exception;

import com.edu.work.comfortbus.exception.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SystemException extends RuntimeException {

    private ErrorCode errorCode;

    public SystemException(final String message, final ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
