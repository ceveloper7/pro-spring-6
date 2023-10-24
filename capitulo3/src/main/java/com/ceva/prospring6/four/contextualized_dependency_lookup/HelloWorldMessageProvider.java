package com.ceva.prospring6.four.contextualized_dependency_lookup;

public class HelloWorldMessageProvider implements MessageProvider{
    public HelloWorldMessageProvider(){
        System.out.println(" --> HelloWorldMessageProvider: constructor called");
    }
    @Override
    public String getMessage() {
        return "Hello world";
    }
}
