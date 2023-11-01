package com.ceva.prospring6.four.inyectionbyconstructor;

import com.ceva.prospring6.four.decoupled.MessageProvider;

public class HelloWorldMessageProviderIC implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world";
    }
}
