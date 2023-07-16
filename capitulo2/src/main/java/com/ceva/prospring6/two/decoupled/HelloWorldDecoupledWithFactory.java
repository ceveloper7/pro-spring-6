package com.ceva.prospring6.two.decoupled;

public class HelloWorldDecoupledWithFactory {
    public static void main(String[] args) {
        MessageRenderer mr = MessageSupportFactory.getInstace().getMessageRenderer()
                .orElseThrow(()-> new IllegalArgumentException("Service of type MessageRenderer was not found"));
        MessageProvider mp = MessageSupportFactory.getInstace().getMessageProvider()
                .orElseThrow(()-> new IllegalArgumentException("Service of type MessageProvider was not found"));
        mr.setMessageProvider(mp);
        mr.render();
    }
}
