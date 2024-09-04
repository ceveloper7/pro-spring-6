package com.ceva.spring6.three.setter_dependency_injection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Setter Injection
 */

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.three.setter_dependency_injection") //  spring busca en este paquete todas las clases con @Component
public class SIHelloWorldConfiguration {
}
