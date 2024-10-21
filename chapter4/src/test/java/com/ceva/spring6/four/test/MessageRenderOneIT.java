package com.ceva.spring6.four.test;

import com.ceva.spring6.four.impl.model.MProvider;
import com.ceva.spring6.four.impl.model.MRenderer;
import com.ceva.spring6.four.impl.provider.ProviderConfig;
import com.ceva.spring6.four.impl.render.RendererConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
 * Implementacion de una prueba de integracion
 * Para realizar una prueba de integracion es necesario preparar una contexto de prueba. La configuracion para crear el contexto de la aplicacion
 * se basara en el paquete com.ceva.spring6.four.impl (ProviderConfig, RenderConfig). La prueba comprobara que los beans se crean correctamente.
 *
 */
public class MessageRenderOneIT {
    @Test
    void testConfig(){
        var ctx = new AnnotationConfigApplicationContext(RendererConfig.class, ProviderConfig.class);

        var messageProvider = ctx.getBean(MProvider.class);
        var messageRenderer = ctx.getBean(MRenderer.class);

        // comprobamos que se hayan creado los beans como parte del contexto
        assertAll( "messageTest" ,
                () -> assertNotNull(messageRenderer),
                () -> assertNotNull(messageProvider),
                () -> assertEquals(messageProvider, messageRenderer.getMessageProvider())
        );

        messageRenderer.render();
    }
}
