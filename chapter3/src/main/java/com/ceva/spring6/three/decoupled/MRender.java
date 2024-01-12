package com.ceva.spring6.three.decoupled;

public interface MRender {
    void render();
    void setMessageProvider(MProvider messageProvider);
    MProvider getMessageProvider();
}
