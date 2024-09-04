package com.ceva.spring6.three.validinject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("injectSimpleParams")
public class InjectParam {
    @Value("John Mayer")
    private String name;

    @Value("40")
    private int age;

    @Value("1.92F")
    private float height;

    @Value("true")
    private boolean isDeveloper;

    @Value("1241401112")
    private Long ageInSeconds;

    @Override
    public String toString() {
        return "InjectParam{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", isDeveloper=" + isDeveloper +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
