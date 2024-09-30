package com.ceva.spring6.simple_abstraction_sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * Le indicamos a Spring donde estan las clases con las anotaciones de estereotipo
 */
@Configuration
@ComponentScan(basePackages = {
        "com.ceva.spring6.simple_abstraction_sample.proxies",
        "com.ceva.spring6.simple_abstraction_sample.repositories",
        "com.ceva.spring6.simple_abstraction_sample.services"
})
public class ProjectConfiguration {
}
