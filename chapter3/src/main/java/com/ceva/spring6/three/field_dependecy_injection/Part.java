package com.ceva.spring6.three.field_dependecy_injection;

import org.springframework.stereotype.Component;

@Component
public class Part {
    private String name = "Arandela 5/8\"";

    public Part(){}

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
