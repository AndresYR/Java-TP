package com.informatorio.chadlab.service.input.impl;

import com.informatorio.chadlab.dominio.ExperimentoQuimico;
import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.repository.experimento.ExperimentoRepository;
import com.informatorio.chadlab.service.input.InputExperimentoQuimicoService;
import com.informatorio.chadlab.utils.InputUtils;

public class InputExperimentoQuimicoServiceImpl implements InputExperimentoQuimicoService {

    private ExperimentoRepository experimentoRepository;

    //Constructor
    public InputExperimentoQuimicoServiceImpl(ExperimentoRepository experimentoRepository) {
        this.experimentoRepository = experimentoRepository;
    }

    @Override
    public void inputExperimentoQuimico(Investigador investigador) {

        String nombre = InputUtils.inputTexto("Ingrese el nombre del experimento:");

        int duracion = InputUtils.inputIntPositivo("Ingrese la duración en minutos del experimento:");

        boolean exitoso = InputUtils.inputBoolean("El experimento fue exitoso?");

        String reactivo = InputUtils.inputTexto("Ingrese el nombre del reactivo");

        this.experimentoRepository.guardar(new ExperimentoQuimico(nombre, duracion, exitoso, reactivo, investigador));

        investigador.aumentarCantidadExperimentos();

    }
}
