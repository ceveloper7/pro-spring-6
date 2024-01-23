package com.ceva.spring6.three.method_inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Clase utilitaria que permite abrir un casillero
 */
@Component("keyHelper")
@Scope("prototype")
class KeyHelper {
    public void open(){
    }
}