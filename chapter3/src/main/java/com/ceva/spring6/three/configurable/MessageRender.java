package com.ceva.spring6.three.configurable;

public interface MessageRender {
    public void render();
    public void setMessageProvider(MessageProvider messageProvider);
    public MessageProvider getMessageProvider();
}
