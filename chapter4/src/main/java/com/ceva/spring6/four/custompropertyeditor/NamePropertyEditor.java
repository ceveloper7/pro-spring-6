package com.ceva.spring6.four.custompropertyeditor;

import java.beans.PropertyEditorSupport;

/*
 * NamePropertyEditor que convierte un String con un separador de espacio de nombre y apellido
 */
public class NamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // dividimos la cadena por medio del espacio en blanco como delimitador
        String[] name = text.split("\\s");
        // pasamos los valores a la instancia FullName
        setValue(new FullName(name[0], name[1]));
    }
}
