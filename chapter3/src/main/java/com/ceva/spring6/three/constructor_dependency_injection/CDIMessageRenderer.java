package com.ceva.spring6.three.constructor_dependency_injection;

public interface CDIMessageRenderer {
    void render();

    void setMessageProvider(CDIMessageProvider messageProvider);

    CDIMessageProvider getMessageProvider();
}
