package com.ceva.prospring6.four.setterinyectiondependency;

public class HelloWorldSetterDependencyInyection {
    public static void main(String[] args) {
        MessageProviderSID messageProviderSID = new HelloWordMessageProviderSID();
        MessageRendererSID messageRendererSID = new StandardOutMessageRenderSID(messageProviderSID);
        messageRendererSID.render();
    }
}
