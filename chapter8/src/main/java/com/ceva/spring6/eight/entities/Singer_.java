package com.ceva.spring6.eight.entities;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDate;
import javax.annotation.processing.Generated;

/**
 * Metamodelo para la clase Singer
 */
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Singer.class)
public class Singer_ extends AbstractEntity{
    public static volatile SingularAttribute<Singer, Long> id;
    public static volatile SingularAttribute<Singer, String> firstName;
    public static volatile SingularAttribute<Singer, String> lastName;
    public static volatile SetAttribute<Singer, Album> albums;
    public static volatile SetAttribute<Singer, Instrument> instruments;
    public static volatile SingularAttribute<Singer, LocalDate> birthDate;

    public static final String ID = "id";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String ALBUMS = "albums";
    public static final String INSTRUMENTS = "instruments";
    public static final String BIRTH_DATE = "birthDate";
}
