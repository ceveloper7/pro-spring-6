package com.ceva.prospring6.two;

/*
 * Externalizamos el contenido del mensaje y lo leemos en tiempo de ejecucion
 * desde la linea de comandos.
 * Punto en contra: El componente responsable de renderizar es tambien responsable de
 * obtener el mensaje.
 * Cambiar como es el mensaje obtenido significa cambiar el codigo en el render
 */
public class HelloWorldWithCommandLine {
    public static void main(String[] args) {
        if(args.length > 0){
            System.out.println(args[0]);
        }else{
            System.out.println("Hello world!");
        }
    }
}
