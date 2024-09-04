package com.ceva.spring6.three.decoupled;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MProvider messageProvider = new HelloWorldMProvider();
        MRender messageRender = new StandardOutMessageRender();
        messageRender.setMessageProvider(messageProvider);
        messageRender.printMessage();
    }
}
