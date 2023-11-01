package com.ceva.prospring6.four.inyectionbyconstructor;

import com.ceva.prospring6.four.decoupled.MessageProvider;

public class HelloWorldInyectionByConstructor {
    public static void main(String[] args) {
        MessageProvider mp = new HelloWorldMessageProviderIC();
        MessageRendererIC mr = new StandardOutMessageRenderIC(mp);
        mr.render();
    }
}
