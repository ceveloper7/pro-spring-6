package com.ceva.spring6.three.contextualized_dependency_lookup;

/**
 * CDLDefaultContainer administra el recurso CDLHelloWorldMessageProvider
 * Aqui se hace la busqueda del recurso
 */
public class CDLDefaultContainer implements CDLContainer{
    @Override
    public Object getDependency(String key) {
        if("provider".equals(key)){
            return new CDLHelloWorldMessageProvider();
        }
        throw new RuntimeException("Unknown dependency");
    }
}
