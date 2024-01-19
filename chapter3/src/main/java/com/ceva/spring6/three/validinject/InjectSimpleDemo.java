package com.ceva.spring6.three.validinject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("Assembly")
public class InjectSimpleDemo {
    @Value("1000")
    private int assembly_id;

    @Value("Motor Oil Head")
    private String name;

    @Value("Motor Oil Head Assy")
    private String description;

    @Value("false")
    private boolean isTopLevel;

    public String toString(){
        return "Id: " + assembly_id + "\n" +
                "name: " + name + "\n" +
                "topLevel: " + isTopLevel;
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(InjectSimpleDemo.class);
        ctx.refresh();

        InjectSimpleDemo demo = (InjectSimpleDemo) ctx.getBean("Assembly");
        System.out.println(demo);
    }
}
