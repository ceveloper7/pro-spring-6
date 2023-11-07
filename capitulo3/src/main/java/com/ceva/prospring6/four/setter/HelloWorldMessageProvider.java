package com.ceva.prospring6.four.setter;

import org.springframework.stereotype.Component;

@Component("provider") // marcamos la clase como un bean
public class HelloWorldMessageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello world";
    }
}
