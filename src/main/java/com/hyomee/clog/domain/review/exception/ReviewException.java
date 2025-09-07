package com.hyomee.clog.domain.review.exception;

import com.hyomee.clog.common.response.ErrorCode;
import com.hyomee.clog.common.exception.GeneralException;

public class ReviewException extends GeneralException {

    public ReviewException(ErrorCode errorCode) {
        super(errorCode);
    }
}