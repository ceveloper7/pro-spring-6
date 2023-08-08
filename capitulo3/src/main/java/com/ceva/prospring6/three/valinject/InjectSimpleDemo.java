package com.ceva.prospring6.three.valinject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("inyectSimple")
public class InjectSimpleDemo {
    @Value("Carlos V.")
    private String name;

    @Value("40")
    private int age;

    @Value("1.72")
    private float height;

    @Value("false")
    private boolean developer;

    @Value("123456789")
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
        ctx.register(InjectSimpleDemo.class);
        ctx.refresh();

        InjectSimpleDemo simpleDemo = (InjectSimpleDemo) ctx.getBean("inyectSimple");
        System.out.println(simpleDemo);
    }
}
