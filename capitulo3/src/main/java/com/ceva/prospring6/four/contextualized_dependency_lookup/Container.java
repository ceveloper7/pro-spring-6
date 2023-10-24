package com.ceva.prospring6.four.contextualized_dependency_lookup;

/**
 * Container que provee el servicio de busqueda de dependencia
 * El contenedor usualmente lo provee el servidor d aplicacion o framework
 */
public interface Container {
    Object getDependency(String key);
}
