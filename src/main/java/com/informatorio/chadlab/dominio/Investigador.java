package com.informatorio.chadlab.dominio;

public class Investigador {
    private String nombre;
    private int edad;
    private int cantidadExperimentos;

    //Constructor
    public Investigador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.cantidadExperimentos = 0;
    }

    public void aumentarCantidadExperimentos() {
        this.cantidadExperimentos++;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nEdad: " + this.edad + "\nCantidad de Experimentos: " + this.cantidadExperimentos;
    }


    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getCantidadExperimentos() {
        return cantidadExperimentos;
    }

}
