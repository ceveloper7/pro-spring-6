package com.ceva.spring6.three.decoupled;

public interface MRender {
    void printMessage();
    void setMessageProvider(MProvider messageProvider);
    MProvider getMessageProvider();
}
