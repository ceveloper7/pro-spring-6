package com.ceva.spring6.four.test;

import com.ceva.spring6.four.impl.model.MProvider;
import com.ceva.spring6.four.impl.model.MRenderer;
import com.ceva.spring6.four.impl.provider.ProviderConfig;
import com.ceva.spring6.four.impl.render.RendererConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
 * En esta prueba se comparte el contexto de prueba
 */
public class MessageRenderTwoIT {
    // declaramos al contexto como static
    public static ApplicationContext ctx;

    // compartimos el contexto (ctx) entre los metodos testProvider y testRenderer. Junit llama al metodo setUp() sola una vez
    @BeforeAll
    static void setUp() {
        ctx = new AnnotationConfigApplicationContext(RendererConfig.class, ProviderConfig.class);
    }

    @Test
    void testProvider(){
        var messageProvider = ctx.getBean(MProvider.class);
        assertNotNull(messageProvider);
    }

    @Test
    void testRenderer(){
        var messageRenderer = ctx.getBean(MRenderer.class);
        assertAll( "messageTest" ,
                () -> assertNotNull(messageRenderer),
                () -> assertNotNull(messageRenderer.getMessageProvider())
        );
        messageRenderer.render();
    }
}
