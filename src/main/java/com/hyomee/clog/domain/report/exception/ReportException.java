package com.hyomee.clog.domain.report.exception;

import com.hyomee.clog.common.response.ErrorCode;
import com.hyomee.clog.common.exception.GeneralException;

public class ReportException extends GeneralException {

    public ReportException(ErrorCode errorCode) {
        super(errorCode);
    }
}