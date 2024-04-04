package com.ceva.spring6.six.plain.datasourcecfg_test;

/**
 * Definimos las operaciones standard que se realiza sobre un objeto Singer
 */
public interface SingerDao {
    String findNameById(Long id);
}
