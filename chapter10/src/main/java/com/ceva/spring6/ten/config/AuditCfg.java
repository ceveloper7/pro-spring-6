package com.ceva.spring6.ten.config;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * clase de configuracion que habilita el soporte de auditoria automatica.
 */

@EnableJpaAuditing
@Configuration
public class AuditCfg {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("prospring6-" + RandomStringUtils.random(6, true, true));
    }
}
