package com.informatorio.chadlab.service.experimento;

import com.informatorio.chadlab.dominio.Experimento;

public interface ExperimentoService {

    void mostrarExperimentos();

    void mostrarEstadisticas();

    Experimento mayorDuracion();

    void reporte();
}
