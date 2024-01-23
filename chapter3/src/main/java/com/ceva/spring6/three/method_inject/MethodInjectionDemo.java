package com.ceva.spring6.three.method_inject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

public class MethodInjectionDemo {
    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(LookupConfig.class);

        // recuperamos del contexto una referencia los beans
        var abstractLockOpener = ctx.getBean("abstractLockOpener", LockOpener.class);
        var standardLockOpener = ctx.getBean("standardLockOpener", LockOpener.class);

        // pasamos la referencia al metodo displayInfo()
        // la creacion de instancias de la clase abstracta solo se admite cuando se usa
        // la inyeccion de metodo de busqueda.
        displayInfo("abstractLockOpener", abstractLockOpener);

        displayInfo("standardLockOpener", standardLockOpener);
    }

    // displayInfo() recibe dos tipos de beans distintos, esto lo conseguimos al colocar
    // los metodos de busqueda separado en una interface que los dos beans implementan
    public static void displayInfo(String beanName, LockOpener lockOpener) {
        // creamos dos variables de tipo KeyHelper
        var keyHelperOne = lockOpener.getMyKeyOpener();
        var keyHelperTwo = lockOpener.getMyKeyOpener();

        System.out.println("[" + beanName + "]: KeyHelper Instances the Same?  " + (keyHelperOne == keyHelperTwo));

        var stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (var x = 0; x < 100_000; x++) {
            var keyHelper = lockOpener.getMyKeyOpener();
            keyHelper.open();
        }
        stopWatch.stop();
        // standardLockOpener va a ser mas rapido xq retorna la misma instancia
        // a diferencia de abstractLockOpener que se crea una nueva instancia.
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
