package com.ceva.spring6.three.setter_dependency_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SetterInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SIHelloWorldConfiguration.class);
        SIMessageRenderer renderBean = ctx.getBean("render", SIMessageRenderer.class);
        renderBean.render();
    }
}
