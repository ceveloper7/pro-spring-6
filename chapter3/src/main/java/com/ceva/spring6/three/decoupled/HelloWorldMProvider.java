package com.ceva.spring6.three.decoupled;

public class HelloWorldMProvider implements MProvider{
    @Override
    public String getMessage() {
        return "Hello crueld world";
    }
}
