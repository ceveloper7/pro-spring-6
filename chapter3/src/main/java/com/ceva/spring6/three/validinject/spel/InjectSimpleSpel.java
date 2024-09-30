package com.ceva.spring6.three.validinject.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("injectSimpleSpel")
public class InjectSimpleSpel {

    /*
     * Con Spring expression language SpEL podemos acceder a cualquier bean (injectSimpleConfig) y propiedad administrado por spring
     * y manipularlos para su uso en la aplicacion.
     */
    @Value("#{injectSimpleConfig.name.toUpperCase()}")
    private String name;

    @Value("#{injectSimpleConfig.age + 1}")
    private int age;

    @Value("#{injectSimpleConfig.height}")
    private float height;

    @Value("#{injectSimpleConfig.developer}")
    private boolean isDeveloper;

    @Value("#{injectSimpleConfig.ageInSeconds}")
    private long ageInSeconds;

    @Override
    public String toString() {
        return "Profile Data{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", isDeveloper=" + isDeveloper +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
