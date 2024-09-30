package com.ceva.spring6.three.collectioninject;

import com.ceva.spring6.three.collectioninject.config.CollectionConfig;
import com.ceva.spring6.three.collectioninject.services.CollectingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollectionInjectionDemo {
    public static void main(String... args) {

        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(CollectionConfig.class, CollectingBean.class);
        ctx.refresh();

        var collectingBean = ctx.getBean(CollectingBean.class);
        collectingBean.printCollections();
    }
}
