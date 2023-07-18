package com.ceva.prospring6.three.decoupled.decoupled;

public class ContextualizedDependencyLookupDemo {
    public static void main(String[] args) {
        Container container = new DefaultContainer();

        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.performLookup(container);
        renderer.render();
    }
}
