package com.informatorio.chadlab.dominio;

public class ExperimentoQuimico extends Experimento{
    private String reactivo;
    private Investigador investigador;
    private String tipo;

    //Constructor
    public ExperimentoQuimico(String nombre, int duracion, boolean exitoso, String reactivo, Investigador investigador) {
        super(nombre, duracion, exitoso);
        this.reactivo = reactivo;
        this.investigador = investigador;
        this.tipo = "Químico";
    }

    @Override
    public String toString() {
        return String.format("%-20s%-40s%-20d%-20s%-20s",
                this.getTipo(),
                this.getNombre(),
                this.getDuracion(),
                this.isExitoso(),
                this.getReactivo());
    }

    //Getters
    public String getReactivo() {
        return reactivo;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public String getTipo() {
        return tipo;
    }
}
