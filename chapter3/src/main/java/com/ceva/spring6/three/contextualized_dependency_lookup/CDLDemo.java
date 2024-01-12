package com.ceva.spring6.three.contextualized_dependency_lookup;

public class CDLDemo {
    public static void main(String[] args) {
        CDLContainer container = new CDLDefaultContainer();
        CDLMessageRenderer renderer = new CDLStandardOutMessageRenderer();
        renderer.performLookup(container);

        renderer.render();
    }
}
