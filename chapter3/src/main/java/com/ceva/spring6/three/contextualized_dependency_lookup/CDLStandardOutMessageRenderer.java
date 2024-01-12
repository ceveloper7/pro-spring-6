package com.ceva.spring6.three.contextualized_dependency_lookup;

public class CDLStandardOutMessageRenderer implements CDLMessageRenderer{
    private CDLMessageProvider messageProvider;

    public CDLStandardOutMessageRenderer(){
        System.out.println("--> CDLStandardOutMessageRenderer constructor called");
    }

    // le indicamos al contenedor que requerimos la dependencia
    @Override
    public void performLookup(CDLContainer container) {
        this.messageProvider = (CDLMessageProvider) container.getDependency("provider");
    }

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider of class:" +
                    CDLStandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public String toString() {
        return messageProvider.toString();
    }
}
