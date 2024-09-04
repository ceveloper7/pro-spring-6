package com.ceva.spring6.three.setter_dependency_injection;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * La manera como Spring instancia los beans
 * =========================================
 * 1. Spring instancia el constructor
 * 2. Spring invoca los setter para injectar las dependencias
 */
@Component("render")
public class SIStandardOutMessageRenderer implements SIMessageRenderer{
    private SIMessageProvider messageProvider;
    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider of class:" + SIStandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    // Aplicamos setter dependency injection. @Autowire or @Resource consiguen el mismo objetivo que es hacer la injeccion de dependencia.
    // @Autowired
    @Resource(name = "provider")
    @Override
    public void setSIMessageProvider(SIMessageProvider messageProvider) {
        System.out.println("-- Injecting dependency using setter --");
        this.messageProvider = messageProvider;
    }

    @Override
    public SIMessageProvider getSIMessageProvider() {
        return messageProvider;
    }
}
