package com.ceva.prospring6.three.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {
        /**
         * Creamos una instancia de contenedor spring IoC que hara:
         * Leer las declaraciones bean de la clase de configuracion HelloWorldConfiguration
         * Creacion de los beans
         * Agregar los bean al registro
         * Administracion d los beans
         */
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer renderer = ctx.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }
}
