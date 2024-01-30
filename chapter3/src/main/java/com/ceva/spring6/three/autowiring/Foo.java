package com.ceva.spring6.three.autowiring;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Foo {
    String id = UUID.randomUUID().toString().replace("-","").substring(0,8);
}
