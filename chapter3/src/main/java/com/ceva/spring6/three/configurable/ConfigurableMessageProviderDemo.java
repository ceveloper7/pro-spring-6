package com.ceva.spring6.three.configurable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurableMessageProviderDemo {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        MessageRender renderBean = ctx.getBean("render", MessageRender.class);
        renderBean.render();
    }
}
