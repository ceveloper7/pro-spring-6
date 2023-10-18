package com.ceva.prospring6.four.decoupled;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageProvider mp = new HelloWorldMessageProvider();
        MessageRender mr = new StandardOutMessageRenderer();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
