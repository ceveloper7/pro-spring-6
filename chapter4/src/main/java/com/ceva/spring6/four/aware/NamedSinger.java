package com.ceva.spring6.four.aware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

public class NamedSinger implements BeanNameAware {
    private static Logger logger = LoggerFactory.getLogger(NamedSinger.class);
    private String name;

    /**
     * BeanNameAware.setBeanName() se llama antes que se retorne la primera instancia
     * del bean a su aplicacion mediante la llamada a ApplicationContext.getBean()
     */
    @Override /** @Implements {@link BeanNameAware#setBeanName(String)} */
    public void setBeanName(String beanName) {
        this.name = beanName;
    }

    public void sing() {
        logger.info("Singer " + name + " - sing()");
    }
}
