package com.ceva.spring6.three.constructor_dependency_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConstructorDependencyInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CDIHelloWorldConfiguration.class);
        CDIMessageRenderer renderBean = ctx.getBean("render", CDIMessageRenderer.class);
        renderBean.render();
    }
}
