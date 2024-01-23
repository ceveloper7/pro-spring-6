package com.ceva.spring6.three.method_inject;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * configuracion de los beans
 */
@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.three.method_inject")
class LookupConfig {}