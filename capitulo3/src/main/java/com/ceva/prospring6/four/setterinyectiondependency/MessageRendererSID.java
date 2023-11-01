package com.ceva.prospring6.four.setterinyectiondependency;

import com.ceva.prospring6.four.decoupled.MessageProvider;

public interface MessageRendererSID {
    void render();
    MessageProviderSID getMessageProvider();
}
