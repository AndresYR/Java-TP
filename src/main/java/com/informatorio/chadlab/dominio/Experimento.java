package com.informatorio.chadlab.dominio;

public abstract class Experimento {
    private String nombre;
    private int duracion;
    private boolean exitoso;

    //Constructur
    public Experimento(String nombre, int duracion, boolean exitoso) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.exitoso = exitoso;
    }


    //Getters

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean isExitoso() {
        return exitoso;
    }
}
