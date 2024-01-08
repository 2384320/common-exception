package com.commonexception.response;

import com.commonexception.exception.ErrorCode;
import com.commonexception.exception.ValidResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultData {
    ErrorCode errorCode;
    Object result;

    public ResultData(ErrorCode errorCode, BindingResult bindingResult) {
        this.errorCode = errorCode;
        this.result = bindingResult
                .getFieldErrors()
                .stream()
                .map(ValidResult::new).collect(Collectors.toList());
    }

    public ResultData(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
