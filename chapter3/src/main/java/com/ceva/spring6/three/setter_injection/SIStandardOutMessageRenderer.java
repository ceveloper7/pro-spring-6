package com.ceva.spring6.three.setter_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("renderer")
public class SIStandardOutMessageRenderer implements SIMessageRenderer{
    private SIMessageProvider messageProvider;
    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider of class:" + SIStandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Autowired
    @Override
    public void setSIMessageProvider(SIMessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public SIMessageProvider getSIMessageProvider() {
        return messageProvider;
    }
}
