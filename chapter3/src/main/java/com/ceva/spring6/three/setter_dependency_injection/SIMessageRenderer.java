package com.ceva.spring6.three.setter_dependency_injection;

public interface SIMessageRenderer {
    void render();
    void setSIMessageProvider(SIMessageProvider messageProvider);
    SIMessageProvider getSIMessageProvider();
}
