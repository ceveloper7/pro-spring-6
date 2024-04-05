package com.ceva.spring6.six.namedparameter;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;

import static com.ceva.spring6.six.QueryConstants.NAMED_FIND_NAME;

public class NamedTemplateDao implements SingerDao{
    private NamedParameterJdbcTemplate namedTemplate;

    public void setNamedTemplate(NamedParameterJdbcTemplate namedTemplate) {
        this.namedTemplate = namedTemplate;
    }
    @Override
    public String findNameById(Long id) {
        return  namedTemplate.queryForObject(NAMED_FIND_NAME, Map.of("singerId", id), String.class);
    }
}
