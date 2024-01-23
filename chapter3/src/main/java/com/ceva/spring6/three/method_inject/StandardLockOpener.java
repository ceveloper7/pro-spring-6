package com.ceva.spring6.three.method_inject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * bean singleton
 */
@Component("standardLockOpener")
class StandardLockOpener implements LockOpener {

    private KeyHelper keyHelper;

    // use setter injection para obtener una instancia de KeyHelper
    @Autowired
    @Qualifier("keyHelper")
    public void setKeyHelper(KeyHelper keyHelper) {
        this.keyHelper = keyHelper;
    }

    @Override
    public KeyHelper getMyKeyOpener() {
        return keyHelper;
    }

    // utilizamos la instancia almacenada en la propiedad keyHelper
    @Override
    public void openLock() {
        keyHelper.open();
    }
}