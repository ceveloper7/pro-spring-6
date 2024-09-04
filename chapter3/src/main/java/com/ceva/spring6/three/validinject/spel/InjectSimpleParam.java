package com.ceva.spring6.three.validinject.spel;

import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleParam {
    private String name = "John Mayer";
    private int age = 40;
    private float height = 1.92f;
    private boolean developer = false;
    private long ageInSeconds = 1_241_401_112L;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isDeveloper() {
        return developer;
    }

    public long getAgeInSeconds() {
        return ageInSeconds;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", developer=" + developer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
