package com.ceva.spring6.three.contextualized_dependency_lookup;

public class CDLHelloWorldMessageProvider implements CDLMessageProvider{
    public CDLHelloWorldMessageProvider(){
        System.out.println("--> CDLHelloWorldMessageProvider: constructor called");
    }
    @Override
    public String getMessage() {
        return "Hello world my friend";
    }
}
