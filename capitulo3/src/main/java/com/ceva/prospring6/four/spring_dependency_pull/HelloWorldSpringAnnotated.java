package com.ceva.prospring6.four.spring_dependency_pull;

import com.ceva.prospring6.four.decoupled.MessageRender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Dependency lookup type: Dependency pull ()
 * ApplicationContext: Es un register de todos los beans que existen dentro de la app
 */
public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        // recuperamos el bean MessageRender del registro central ApplicationContext ctx
        MessageRender mr = ctx.getBean("renderer", MessageRender.class);
        mr.render();
    }
}
