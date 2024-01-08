package com.commonexception;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public void stackTraceTest(){
        int n = 3/0;
    }
}
