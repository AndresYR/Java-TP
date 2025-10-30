package com.informatorio.chadlab.dominio;

import java.util.List;

public class ExperimentoFisico extends Experimento{
    private String instrumento;
    private List<Investigador> investigadores;

    //Constructor
    public ExperimentoFisico(String nombre, int duracion, boolean exitoso, String instrumento, List<Investigador> investigadores) {
        super(nombre, duracion, exitoso);
        this.instrumento = instrumento;
        this.investigadores = investigadores;
    }

    //Getters
    public String getInstrumento() {
        return instrumento;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }
}
