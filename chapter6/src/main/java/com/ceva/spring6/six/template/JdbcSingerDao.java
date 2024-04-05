package com.ceva.spring6.six.template;

import org.springframework.jdbc.core.JdbcTemplate;

import static com.ceva.spring6.six.QueryConstants.PARAMETRIZED_FIND_NAME;

public class JdbcSingerDao implements SingerDao{
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String findNameById(Long id) {
        // recuperamos el valor del nombre del Singer
        // param 1 -> query sql
        // param 2 -> el tipo de dato de retorno
        return jdbcTemplate.queryForObject(PARAMETRIZED_FIND_NAME, String.class, id);
    }
}
