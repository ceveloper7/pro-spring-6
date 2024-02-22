package com.ceva.spring6.four.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

/**
 * NessageDisgestFactoryBean pasa un clon de la instancia MessageDigest almacenada
 * que se crea en el callback de inicializacion InitializingBean.afterPropertiesSet()
 */
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {
    private String algorithmName = "MD5";

    private MessageDigest messageDigest = null;

    /**
     * Reacuperamos el objeto messageDigest creado por el Factorybean
     */
    @Override /** @Implements {@link FactoryBean#getObject()} */
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    /**
     * getObjectType() le indica a spring que tipo devolvera su FactoryBean
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

    @Override /** @Implements {@link InitializingBean#afterPropertiesSet()} */
    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
