package com.ceva.spring6.four.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

public class ShutdownHookBean implements ApplicationContextAware {
    private ApplicationContext ctx;
    /** @Implements {@link ApplicationContextAware#setApplicationContext(ApplicationContext)} }*/
    // Spring llama a este metodo para pasarle a nuestro bean una referencia del ApplicationContext
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        // validamos que el ApplicationContext sea de tipo GenericApplicationContext
        if (ctx instanceof GenericApplicationContext) {
            // registramos un ShutdownHook
            ((GenericApplicationContext) ctx).registerShutdownHook();
        }
    }
}
