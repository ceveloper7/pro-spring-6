package com.ceva.spring6.four.initmethod;

import org.slf4j.Logger;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.LoggerFactory;

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

    /* metodo que actua como callback init */
    private void init() {
        logger.info("Initializing bean");
        // verificamos si se ha establecido la propiedad name
        if (name == null) {
            logger.info("Using default name");
            // si name no esta establecida, usamos un valor predeterminado
            name = DEFAULT_NAME;
        }
        // comprobamos si la propiedad age se ha establecido
        if (age == Integer.MIN_VALUE) {
            // si no esta establecido, lanzamos una excepcion
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
