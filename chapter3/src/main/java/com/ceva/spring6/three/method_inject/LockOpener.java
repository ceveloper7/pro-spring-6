package com.ceva.spring6.three.method_inject;

public interface LockOpener {
    // clase que se inject para abrir un casillero

    // retornamos una referencia a una instanci de KeyHelper
    KeyHelper getMyKeyOpener();
    void openLock();
}
