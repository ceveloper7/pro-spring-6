package com.ceva.spring6.three.field_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("singer")
public class Singer {

    @Autowired
    private Inspiration inspiration;

    public void sing(){
        System.out.println("... " + inspiration.getLyric());
    }
}
