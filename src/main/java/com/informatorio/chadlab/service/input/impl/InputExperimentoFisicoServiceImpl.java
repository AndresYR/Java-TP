package com.informatorio.chadlab.service.input.impl;

import com.informatorio.chadlab.dominio.ExperimentoFisico;
import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.repository.experimento.ExperimentoRepository;
import com.informatorio.chadlab.service.input.InputExperimentoFisicoService;
import com.informatorio.chadlab.utils.InputUtils;

import java.util.List;

public class InputExperimentoFisicoServiceImpl implements InputExperimentoFisicoService {

    private ExperimentoRepository experimentoRepository;

    public InputExperimentoFisicoServiceImpl(ExperimentoRepository experimentoRepository) {
        this.experimentoRepository = experimentoRepository;
    }

    @Override
    public void inputExperimentoFisico(List<Investigador> investigadores) {

        String nombre = InputUtils.inputTexto("Ingrese el nombre del experimento:");

        int duracion = InputUtils.inputIntPositivo("Ingrese la duración en minutos del experimento:");

        boolean exitoso = InputUtils.inputBoolean("El experimento fue exitoso?");

        String instrumento = InputUtils.inputTexto("Ingrese el nombre del instrumento");

        this.experimentoRepository.guardar(new ExperimentoFisico(nombre, duracion, exitoso, instrumento, investigadores));

    }
}
