package com.hyomee.clog.domain.like.exception;

import com.hyomee.clog.common.response.ErrorCode;
import com.hyomee.clog.common.exception.GeneralException;

public class LikeException extends GeneralException {

    public LikeException(ErrorCode errorCode) {
        super(errorCode);
    }
}