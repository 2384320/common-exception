package com.commonexception.response;

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
    int code = ResultCodeConstant.SUC_CD;
    String msg;
    Object result;

    public ResultData(BindingResult bindingResult){
        this.code = ResultCodeConstant.VAL_FAIL_CD;
        this.result = bindingResult
                .getFieldErrors()
                .stream()
                .map(e -> new ValidResult(e)).collect(Collectors.toList());
    }
}
