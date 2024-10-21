package com.ceva.spring6.four.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ceva.spring6.four.impl.model.MProvider;
import com.ceva.spring6.four.impl.model.MRenderer;
import com.ceva.spring6.four.impl.provider.ProviderConfig;
import com.ceva.spring6.four.impl.render.RendererConfig;

// @ExtendWith es requerida junto con SpringExtension.class, SpringExtension permite indicar como configurar la extension para Spring
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RendererConfig.class, ProviderConfig.class}) // indicamos las clases para configurar el contexto de la app
public class MessageRenderBestWayTest {
    @Autowired
    MRenderer messageRenderer;

    @Autowired
    MProvider messageProvider;

    @Test
    void testProvider(){
        assertNotNull(messageProvider);
    }

    @Test
    void testRenderer(){
        assertAll( "messageTest" ,
                () -> assertNotNull(messageRenderer),
                () -> assertNotNull(messageRenderer.getMessageProvider())
        );
        messageRenderer.render();
    }
}
