package com.commonexception;

import com.commonexception.exception.ErrorConstant;
import com.commonexception.exception.SVCException;
import com.commonexception.response.ResultData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @PostMapping("/test/{etc}")
    public ResponseEntity exceptionTest(@Validated @RequestBody TestDto dto, @PathVariable String etc) {

        if(etc.equals("first")) throw new SVCException(ErrorConstant.TEST_COUPON_ERROR_NONE_PK);
        else if(etc.equals("second")) throw new SVCException(ErrorConstant.TEST_ETC);
        else if(etc.equals("third")) throw new SVCException(".");
        else if (etc.equals("trace")) testService.stackTraceTest();
        return new ResponseEntity(new ResultData(), HttpStatus.OK);
    }
}
