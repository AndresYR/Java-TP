package com.informatorio.chadlab.dominio;

public class ExperimentoQuimico extends Experimento{
    private String reactivo;
    private Investigador investigador;

    //Constructor
    public ExperimentoQuimico(String nombre, int duracion, boolean exitoso, String reactivo, Investigador investigador) {
        super(nombre, duracion, exitoso);
        this.reactivo = reactivo;
        this.investigador = investigador;
    }

    //Getters
    public String getReactivo() {
        return reactivo;
    }

    public Investigador getInvestigador() {
        return investigador;
    }
}
