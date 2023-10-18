package com.ceva.prospring6.four;

/**
 * El problema con esta aplicacion es que el componente responsable para renderizar la
 * respuesta es el mismo responsable para obtener el mensaje
 */
public class HelloWorldWithCommandLine {
    public static void main(String[] args) {
        if(args.length > 0){
            System.out.println(args[0]);
        }
        else{
            System.out.println("Hello world");
        }
    }
}
