package com.ceva.spring6.four.integration_testing_impl.render;

import com.ceva.spring6.four.advancedconfig.MessageProvider;
import com.ceva.spring6.four.advancedconfig.MessageRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StandardOutMessageRenderer implements MessageRenderer {
    private static Logger logger = LoggerFactory.getLogger(StandardOutMessageRenderer.class);

    private MessageProvider messageProvider;

    @Override
    @Autowired
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }

    @Override
    public void render() {
        logger.info(messageProvider.getMessage());
    }
}
