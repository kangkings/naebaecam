package com.example.test2;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    // 요청 성공
    SUCCESS(true, "요청이 성공하였습니다."),
    // 요청 실패
    FAIL(false, "요청에 실패했습니다.");
    private boolean isSuccess;
    private String message;

    BaseResponseStatus(Boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }
}