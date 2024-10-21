package com.ceva.spring6.four.impl.render;

import com.ceva.spring6.four.advancedconfig.MessageProvider;
import com.ceva.spring6.four.advancedconfig.MessageRenderer;
import com.ceva.spring6.four.impl.model.MProvider;
import com.ceva.spring6.four.impl.model.MRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class StandardOutMessageRenderer implements MRenderer {
    private static Logger logger = LoggerFactory.getLogger(StandardOutMessageRenderer.class);

    private MProvider messageProvider;

    @Autowired
    @Override
    public void setMessageProvider(MProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MProvider getMessageProvider() {
        return this.messageProvider;
    }

    @Override
    public void render() {
        logger.info(messageProvider.getMessage());
    }
}
