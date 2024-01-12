package com.ceva.spring6.three.contextualized_dependency_lookup;

public interface CDLContainer {
    Object getDependency(String key);
}
