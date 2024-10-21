package com.ceva.spring6.four.impl.provider;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.impl")
public class ProviderConfig {
}
