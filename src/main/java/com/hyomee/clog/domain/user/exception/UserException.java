package com.hyomee.clog.domain.user.exception;

import com.hyomee.clog.common.response.ErrorCode;
import com.hyomee.clog.common.exception.GeneralException;

public class UserException extends GeneralException {

    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }
}