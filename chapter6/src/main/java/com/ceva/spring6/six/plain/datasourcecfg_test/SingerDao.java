package com.ceva.spring6.six.plain.datasourcecfg_test;

/**
 * Definimos las operaciones standard que se realiza sobre un objeto Singer
 * EL Patron DAO tiene los siguientes requisitos:
 * 1. Interface DAO donde se definen las operaciones que se realizaran sobre un objeto.
 * 2. Implementacion DAO esta clase proporciona la implementacion concreta para la interface DAO
 * 3. Objetos modelados, tambien llamados entidades, se trata de simple POJOs de un registro de tabla.
 */
public interface SingerDao {
    String findNameById(Long id);
}
