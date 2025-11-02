package com.informatorio.chadlab.repository.experimento.impl;

import com.informatorio.chadlab.dominio.Experimento;
import com.informatorio.chadlab.repository.experimento.ExperimentoRepository;

import java.util.ArrayList;
import java.util.List;

public class ExperimentoRepositoryImpl implements ExperimentoRepository {

    List<Experimento> experimentos = new ArrayList<>();

    @Override
    public Experimento guardar(Experimento experimento) {
        experimentos.add(experimento);
        return experimento;
    }

    @Override
    public List<Experimento> obtenerExperimentos() {
        return this.getExperimentos();
    }

    //Getters
    public List<Experimento> getExperimentos() {
        return experimentos;
    }
}
