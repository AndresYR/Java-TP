package com.informatorio.chadlab.dominio;

public class Investigador {
    private String nombre;
    private int edad;

    //Constructor
    public Investigador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }


    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
