package com.ceva.spring6.three.constructor_dependency_injection;

import org.springframework.stereotype.Component;

@Component("provider")
public class CDIHelloWorldMessageProvider implements CDIMessageProvider{
    @Override
    public String getMessage() {
        return "Hey, hello world";
    }
}
