package com.ceva.prospring6.two.annotated;

import com.ceva.prospring6.two.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {
        // Dependency lookup type: Dependency pull ()
        // ApplicationContext: Es un register de todos los beans que existen dentro de la app
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        // recuperamos el componente MessageRenderer del ApplicationContext
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
