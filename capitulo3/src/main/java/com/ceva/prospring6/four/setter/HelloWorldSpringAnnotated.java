package com.ceva.prospring6.four.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HellowWorldConfiguration.class);
        MessageRenderer r = ctx.getBean("renderer", MessageRenderer.class);
        r.render();
    }
}
