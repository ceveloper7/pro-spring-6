package com.ceva.prospring6.three.decoupled;

/*
* Container que provee un servicio de busqueda de dependencia
 */
public interface Container {
    Object getDependency(String key);
}
