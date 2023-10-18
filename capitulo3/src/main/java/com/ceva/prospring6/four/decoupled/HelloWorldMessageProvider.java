package com.ceva.prospring6.four.decoupled;

/**
 * MessageProvider que siempre retorna un Hello world
 */
public class HelloWorldMessageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello world";
    }
}
