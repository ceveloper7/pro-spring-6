package com.ceva.spring6.four.advancedconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardOutMessageRenderer implements MessageRenderer{
    private static Logger LOGGER = LoggerFactory.getLogger(StandardOutMessageRenderer.class);

    private MessageProvider messageProvider;

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }

    @Override
    public void render() {
        LOGGER.info(messageProvider.getMessage());
    }
}
