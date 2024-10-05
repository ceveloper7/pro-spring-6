package com.ceva.spring6.four.all;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Entendiendo el Orden de Resolucion de las CallBack de Inicializacion
 * 1. El constructor es llamado primero para crear el bean
 * 2. Las dependencias son injectadas (los setters son llamados) el bean BeanPostProcessor es consultado para llamar a los setters
 * 3. Ahora que el bean existe y las dependencias fueron provistas. La anotacion @PostConstruct por el el bean CommonAnnotationBeanPostProcessor
 *    asi que este bean llamara al metodo o metodos anotados con @PostConstruct. Este metodo es ejecutado inmediatamente despues que el bean ha
 *    sido construido y antes que la clase se ponga en service
 * 4. El metodo afterPropertiesSet de InitializingBean se ejecuta justo despues de que se inyecten as dependencias.
 */
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