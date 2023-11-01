package com.ceva.prospring6.four.setterinyectiondependency;

public class HelloWordMessageProviderSID implements MessageProviderSID{
    @Override
    public String getMessage() {
        return "Hello world";
    }
}
