package com.ceva.spring6.three.method_inject;


import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * bean singleton
 */
@Component("abstractLockOpener")
abstract class AbstractLockOpener implements LockOpener {

    // use method injection para obtener una instancia de KeyHelper o subclase de ella
    // por medio de la anotacion @LookUp configuramos el metodo de busqueda
    @Lookup("keyHelper")
    @Override
    public abstract KeyHelper getMyKeyOpener() ;

    // llamamos al metodo abstract getMyKeyOpener para obtener la instancia de KeyHelper
    @Override
    public void openLock() {
        getMyKeyOpener().open();
    }
}

