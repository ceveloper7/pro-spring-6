package com.ceva.spring6.three.setter_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SetterInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SIHelloWorldConfiguration.class);
        SIMessageRenderer renderer = ctx.getBean("renderer", SIMessageRenderer.class);
        renderer.render();
    }
}
