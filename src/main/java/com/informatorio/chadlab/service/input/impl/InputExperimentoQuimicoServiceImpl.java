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

        //Harcodeo por el momento
        String nombre = "Exp quim 1";

        int duracion = 45;

        boolean exitoso = true;

        String reactivo = "hidrogeno";

        this.experimentoRepository.guardar(new ExperimentoQuimico(nombre, duracion,
                exitoso, reactivo, investigador));

    }
}
