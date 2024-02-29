package com.ceva.spring6.four.custompropertyeditor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomPropertyEditorDemo {
    private static Logger LOGGER = LoggerFactory.getLogger(CustomPropertyEditorDemo.class);

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(CustomPropertyEditorCfg.class);

        var person = ctx.getBean(Person.class, "person");
        LOGGER.info("Person full nam = {}" , person.getName());

        ctx.close();
    }
}
