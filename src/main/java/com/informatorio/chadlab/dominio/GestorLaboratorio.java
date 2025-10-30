package com.informatorio.chadlab.dominio;

import java.util.ArrayList;
import java.util.List;

public class GestorLaboratorio {
    private List<Experimento> experimentos;
    private List<Investigador> investigadores;

    //Constructor
    public GestorLaboratorio() {
        this.experimentos = new ArrayList<>();
        this.investigadores = new ArrayList<>();
    }

    //Methods
    public void registrarInvestigador(String nombre, int edad) {
        this.investigadores.add(new Investigador(nombre, edad));
    }

    public void registrarExperimentoQuimico(String reactivo, Investigador investigador) {
//        this.experimentos.add(new ExperimentoQuimico(reactivo,investigador));
    }

    //Getters
    public List<Experimento> getExperimentos() {
        return experimentos;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }
}
