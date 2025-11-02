package com.informatorio.chadlab.repository.experimento;

import com.informatorio.chadlab.dominio.Experimento;

import java.util.List;

public interface ExperimentoRepository {

    Experimento guardar(Experimento experimento);

    List<Experimento> obtenerExperimentos();
}
