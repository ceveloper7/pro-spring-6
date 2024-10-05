package com.ceva.spring6.four.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

/**
 * Los FactoryBean son la solucion perfecta cuando se trabaja con clases que no se pueden crear por medio del operador new.
 * SI tenemos objetos que se crean mediante un metodo de fabrica y los queremos usar en una aplicacion spring, se debe crear un
 * FactoryBean que actua como adaptador, permitiendo que sus clases aprovechen al maximo las capacidades del IoC de Spring
 *
 * MessageDisgestFactoryBean pasa un clon de la instancia MessageDigest almacenada
 * que se crea en el callback de inicializacion InitializingBean.afterPropertiesSet()
 * Spring se encargara de la gestion del objeto MessageDigest
 */
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {
    private String algorithmName = "MD5";

    private MessageDigest messageDigest = null;

    /**
     * Spring llama a este metodo para recuperar el objeto messageDigest creado por el Factorybean
     */
    @Override /** @Implements {@link FactoryBean#getObject()} */
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    /**
     * getObjectType() le indica a spring que tipo devolvera su FactoryBean es un objeto de tipo MessageDigest
     */
    @Override /** @Implements {@link FactoryBean#getObjectType()} */
    public Class<MessageDigest> getObjectType() {
        return MessageDigest.class;
    }

    /**
     * este metodo informa a spring si FactoryBean esta administrando una instancia singleton
     *
     */
    /** @Implements {@link FactoryBean#isSingleton()} */
    public boolean isSingleton() {
        return true;
    }

    /**
     * Pasamos un clon de la instancia MessageDigest
     */
    @Override /** @Implements {@link InitializingBean#afterPropertiesSet()} */
    public void afterPropertiesSet() throws Exception {
        // Obtenemos una implementacion concreta MessageDigest pasando el algoritmo
        messageDigest = MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
