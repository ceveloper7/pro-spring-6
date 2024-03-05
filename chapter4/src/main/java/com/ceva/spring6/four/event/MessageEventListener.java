package com.ceva.spring6.four.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessageEventListener implements ApplicationListener<MessageEvent> {
    private static Logger LOGGER = LoggerFactory.getLogger(MessageEventListener.class);
    @Override
    public void onApplicationEvent(MessageEvent event) {
        LOGGER.info("Received: {}" , event.getMessage());
    }
}
