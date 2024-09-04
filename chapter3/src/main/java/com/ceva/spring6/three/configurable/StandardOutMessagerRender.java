package com.ceva.spring6.three.configurable;

import com.ceva.spring6.three.setter_dependency_injection.SIStandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("render")
public class StandardOutMessagerRender implements MessageRender{
    private MessageProvider messageProvider;
    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("You must set the property messageProvider of class:" + SIStandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    @Autowired
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
