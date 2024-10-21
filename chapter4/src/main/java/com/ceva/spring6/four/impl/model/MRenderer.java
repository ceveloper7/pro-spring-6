package com.ceva.spring6.four.impl.model;

import com.ceva.spring6.four.advancedconfig.MessageProvider;

public interface MRenderer {
    void render();
    void setMessageProvider(MProvider messageProvider);
    MProvider getMessageProvider();
}
