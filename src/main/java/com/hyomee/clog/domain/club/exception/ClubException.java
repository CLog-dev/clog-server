package com.hyomee.clog.domain.club.exception;

import com.hyomee.clog.common.response.ErrorCode;
import com.hyomee.clog.common.exception.GeneralException;

public class ClubException extends GeneralException {

    public ClubException(ErrorCode errorCode) {
        super(errorCode);
    }
}