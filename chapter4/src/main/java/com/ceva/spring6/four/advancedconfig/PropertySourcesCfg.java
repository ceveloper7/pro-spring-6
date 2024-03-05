package com.ceva.spring6.four.advancedconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.advancedconfig")
@PropertySource(value = "classpath:message.properties") // cargamos archivo propiedades
public class PropertySourcesCfg {
    @Autowired
    Environment env;

    // inyectamos el archivo de propiedades en la clase que implementa MessageProvider
    @Bean
    @Lazy // instanciamos el bean solo cuando es requerido
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean(name = "messageRenderer")
    @Scope(value="prototype") // el scope del bean no sera singleton
    @DependsOn(value="messageProvider") // el bean messageRenderer depende de messageProvider
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
