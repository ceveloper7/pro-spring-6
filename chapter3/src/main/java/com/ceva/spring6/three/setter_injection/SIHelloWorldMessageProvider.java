package com.ceva.spring6.three.setter_injection;

import org.springframework.stereotype.Component;

@Component("provider")
public class SIHelloWorldMessageProvider implements SIMessageProvider{
    @Override
    public String getMessage() {
        return "Hi, sending a message";
    }
}
