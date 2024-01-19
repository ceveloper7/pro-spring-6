package com.ceva.spring6.three.field_dependecy_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kit {
    @Autowired
    private Part part;

    public void showKit(){
        System.out.println("...." + part.getName());
    }

}
