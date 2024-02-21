package com.ceva.spring6.four.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareDemo {
    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(AwareConfig.class);

        var singer = ctx.getBean(NamedSinger.class);
        singer.sing();

        //ctx.registerShutdownHook(); // no longer needed because of the ShutdownHookBean
    }
}
