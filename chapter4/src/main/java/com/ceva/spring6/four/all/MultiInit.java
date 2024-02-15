package com.ceva.spring6.four.all;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

class MultiInit implements InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(MultiInit.class);
    private Dependency dependency;

    public MultiInit() {
        logger.info("1. Calling constructor for bean of type {}.", MultiInit.class);
    }

    public Dependency getDependency() {
        return dependency;
    }

    @Autowired
    public void setDependency(Dependency dependency) {
        logger.info("2. Calling setDependency for bean of type {}.", MultiInit.class);
        this.dependency = dependency;
    }

    @PostConstruct
    private void postConstruct() throws Exception {
        logger.info("3. Calling postConstruct() for bean of type {}.", MultiInit.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("4. Calling afterPropertiesSet() for bean of type {}.", MultiInit.class);
    }

    private void initMe() throws Exception {
        logger.info("5. Calling initMethod() for bean of type {}.", MultiInit.class);
    }
}