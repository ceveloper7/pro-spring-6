package com.ceva.spring6.six.template;

import org.springframework.jdbc.core.JdbcTemplate;

import static com.ceva.spring6.six.QueryConstants.PARAMETRIZED_FIND_NAME;

/*
 * Clase de implementacion de interfaz DAO SingerDao
 */
public class JdbcSingerDao implements SingerDao{
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String findNameById(Long id) {
        // queryForObjects permite recuperamos el valor del nombre del Singer
        // param 1 -> query sql
        // param 2 -> el tipo de dato de retorno
        // param 3 -> parametro que se envia a la sentencia sql
        return jdbcTemplate.queryForObject(PARAMETRIZED_FIND_NAME, String.class, id);
    }
}
