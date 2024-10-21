package com.ceva.spring6.four.impl;

import com.ceva.spring6.four.advancedconfig.MessageProvider;
import com.ceva.spring6.four.advancedconfig.MessageRenderer;
import com.ceva.spring6.four.impl.model.MProvider;
import com.ceva.spring6.four.impl.model.MRenderer;
import com.ceva.spring6.four.impl.provider.ConfigurableMessageProvider;
import com.ceva.spring6.four.impl.render.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
 * Clase de configuracion con el bean MProvider asociado al perfil dev
 */
@Configuration
public class AllConfig {
    // MProvider esta asociado al perfil dev
    @Profile("dev")
    @Bean
    MProvider messageProvider(){
        return new ConfigurableMessageProvider("Text Sample");
    }

    /*
     * MRenderer no esta asociado a un perfil. Al no estar asociado con un perfil significa que MRendere serpa parte del contexto
     * independientemente del perfil que este activo, que es el nos interesa, porque este es el bean que nos interesa probar.
     * Para probar el bean MRenderer necesitamos proporcionar una dependencia MProvider diferente en el ctx de prueba
     */
    @Bean
    MRenderer messageRenderer(){
        MRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return  messageRenderer;
    }
}
