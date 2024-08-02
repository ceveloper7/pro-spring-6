package com.ceva.spring6.eleven.property.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * LocalDatePropertyEditor: es un editor de propiedades personalizado
 * clase que le indica a Spring como realizar la conversion de un String a LocalDate
 */
public class LocalDatePropertyEditor extends PropertyEditorSupport {
    private DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(LocalDate.parse(text, dateFormat));
    }
}
