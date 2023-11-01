package com.ceva.prospring6.four.inyectionbyconstructor;

import com.ceva.prospring6.four.decoupled.MessageProvider;

public interface MessageRendererIC {
    void render();
    MessageProvider getMessageProvider();
}
