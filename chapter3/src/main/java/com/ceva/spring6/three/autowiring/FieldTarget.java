package com.ceva.spring6.three.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
// anotacion que indica a spring crear una instancia solo cuando se solicita por primera vez
@Lazy
public class FieldTarget {
    @Autowired
    @Qualifier("foo") Foo fooOne;

    @Autowired @Qualifier("anotherFoo") Foo fooTwo;

    @Autowired Bar bar;
}
