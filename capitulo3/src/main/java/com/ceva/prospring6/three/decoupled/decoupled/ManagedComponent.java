package com.ceva.prospring6.three.decoupled.decoupled;

/*
 * La Busqueda de dependencia contextualizada funciona haciendo que el componente que requiere
 * una dependencia implemente una interface.
 *
 */
public interface ManagedComponent{
    void performLookup(Container container);
}
