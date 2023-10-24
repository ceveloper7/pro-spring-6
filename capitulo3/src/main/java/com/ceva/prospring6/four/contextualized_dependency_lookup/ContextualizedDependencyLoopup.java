package com.ceva.prospring6.four.contextualized_dependency_lookup;

public class ContextualizedDependencyLoopup {
    public static void main(String[] args) {
        Container container = new DefaultContainer();
        MessageRenderer mr = new StandardOutMessageRenderer();
        mr.performLookup(container);

        mr.render();
    }
}
