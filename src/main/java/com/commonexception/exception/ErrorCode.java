package com.commonexception.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /**
     * [이름 규칙]
     * 도메인_에러_에러내용
     *
     * [에러 코드]
     * 4xxxx, 5xxxx : 서버 관련 응답
     * 5?xxx, 6?xxx : 도메인 관련 응답
     */

    TEST_COUPON_ERROR_NONE_PK(30001, "존재하지 않는 쿠폰입니다."),
    TEST_ETC(30002, "에러 메시지"),

    INPUT_ERROR_VALIDATION(40001, "입력값 유효성 검증 실패입니다."),

    SERVER_ERROR_UNDEFINED(50001, "알수 없는 에러입니다. 개발자에게 문의바랍니다."),
    SERVER_ERROR_JSON_PARSE(50002, "잘못된 형식의 json body 입니다. 개발자에게 문의바랍니다.");

    private final int code;
    private final String msg;
}
