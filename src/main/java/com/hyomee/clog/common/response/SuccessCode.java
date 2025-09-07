package com.hyomee.clog.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    // ⚪ 200
    DEFAULT(20000, "요청이 성공적으로 처리되었습니다."),

    // ⚪ 201
    USER_CREATED(20101, "사용자가 생성되었습니다.");

    private final int code;
    private final String message;
}