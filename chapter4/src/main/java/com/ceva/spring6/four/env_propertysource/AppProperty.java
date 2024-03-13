package com.ceva.spring6.four.env_propertysource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

/**
 * Clase que almacena todas las propiedades de una app leidas desde un archivo de propiedades
 */
@Component
public class AppProperty {
    private String applicationHome;
    private String userHome;
    public String getApplicationHome() {
        return applicationHome;
    }

    @Autowired
    public void setApplicationHome(@Value("${application.home}") String applicationHome) {
        this.applicationHome = applicationHome;
    }

    public String getUserHome() {
        return userHome;
    }

    @Autowired
    public void setUserHome(@Value("${user.home}")String userHome) {
        this.userHome = userHome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("applicationHome", applicationHome)
                .append("userHome", userHome)
                .toString();
    }
}
