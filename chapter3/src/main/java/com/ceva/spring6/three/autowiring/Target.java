package com.ceva.spring6.three.autowiring;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase Target con 3 constructores
 */
@Component
@Lazy
public class Target {
    private static Logger logger = LoggerFactory.getLogger(Target.class);
    // declaramos 3 propiedades
    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    // constructor sin argumento
   public Target() {
        logger.info(" --> Target() called");
    }

    // constructor que acepta una instancia de Foo
    //@Autowired
    public Target(@Qualifier("foo") Foo foo) {
        this.fooOne = foo;
        logger.info(" --> Target(Foo) called");
    }

    // constructor que acepta una instancia de Foo y Bar
    @Autowired
    public Target(@Qualifier("foo")Foo foo, Bar bar) {
        this.fooOne = foo;
        this.bar = bar;
        logger.info(" --> Target(Foo, Bar) called");
    }
}
