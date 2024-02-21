package com.ceva.spring6.four.jsr250PostConstruct;

import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * En este ejemplo utilizamos la anotacion @PostConstruct que pertenece al
 * ciclo de vida JSR-250
 * Las anotaciones JSR-250 son compatibles para especificar el metodo que spring debe
 * llamar si la anotacion correspondiente relacionada al ciclo de vida del bean existe
 * en la clase.
 */
public class Singer {
    private static Logger logger = LoggerFactory.getLogger(Singer.class);
    private static final String DEFAULT_NAME = "No Name";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        logger.info("Calling setName for bean of type {}.", Singer.class);
        this.name = name;
    }

    public void setAge(int age) {
        logger.info("Calling setAge for bean of type {}.", Singer.class);
        this.age = age;
    }

    /**
     * llamamos al metodo postConstruct solo para que sea obvio cual es
     * el proposito del metodo, se puede nombrar el metodo como uno desee.
     */
    @PostConstruct
    private void postConstruct() throws Exception {
        logger.info("Initializing bean using 'postConstruct()'");
        if (name == null) {
            logger.info("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "You must set the age property of any beans of type " + Singer.class);
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .toString();
    }
}
