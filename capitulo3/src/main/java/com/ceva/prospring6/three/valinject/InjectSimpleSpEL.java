package com.ceva.prospring6.three.valinject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("injectSimpleSpEL")
public class InjectSimpleSpEL {
    @Value("#{injectSimpleConfig.name.toUpperCase}")
    private String name;

    @Value("#{injectSimpleConfig.age + 1}")
    private int age;
    @Value("#{injectSimpleConfig.height}")
    private float height;
    @Value("#{injectSimpleConfig.developer}")
    private boolean developer;
    @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSeconds;

    @Override
    public String toString(){
        return "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Age in seconds: " + ageInSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is developer? " + developer;
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(InjectSimpleConfig.class, InjectSimpleSpEL.class);
        ctx.refresh();
        InjectSimpleSpEL simple = (InjectSimpleSpEL) ctx.getBean("injectSimpleSpEL");
        System.out.println(simple);
    }
}
