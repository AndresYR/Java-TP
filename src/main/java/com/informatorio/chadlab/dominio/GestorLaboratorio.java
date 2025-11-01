package com.informatorio.chadlab.dominio;

import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;
import com.informatorio.chadlab.repository.investigador.impl.InvestigadorRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class GestorLaboratorio {

    InvestigadorRepository investigadorRepository = new InvestigadorRepositoryImpl();

    //Constructor
    public GestorLaboratorio() {}

    //Methods
    public void registrarInvestigador(String nombre, int edad) {
//        investigadorRepository.guardar();
    }

    public void registrarExperimentoQuimico(String reactivo, Investigador investigador) {
//        this.experimentos.add(new ExperimentoQuimico(reactivo,investigador));
    }


}
