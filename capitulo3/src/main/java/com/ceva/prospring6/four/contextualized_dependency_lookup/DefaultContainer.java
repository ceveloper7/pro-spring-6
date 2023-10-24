package com.ceva.prospring6.four.contextualized_dependency_lookup;

public class DefaultContainer implements Container{
    @Override
    public Object getDependency(String key) {
        if("provider".equals(key)){
            return new HelloWorldMessageProvider();
        }
        throw new RuntimeException("Unknown dependency: " + key);
    }
}
