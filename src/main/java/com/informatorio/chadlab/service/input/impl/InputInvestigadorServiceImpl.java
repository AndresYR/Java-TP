package com.informatorio.chadlab.service.input.impl;

import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;
import com.informatorio.chadlab.service.input.InputInvestigadorService;
import com.informatorio.chadlab.utils.InputUtils;

public class InputInvestigadorServiceImpl implements InputInvestigadorService {

    private InvestigadorRepository investigadorRepository;

    public InputInvestigadorServiceImpl(InvestigadorRepository investigadorRepository) {
        this.investigadorRepository = investigadorRepository;
    }

    @Override
    public void inputInvestigador() {

        String nombre = InputUtils.inputTexto("Ingrese el nombre del investigador: ");

        int edad = InputUtils.inputIntPositivo("Ingrese la edad del investigador: ");

        this.investigadorRepository.guardar(new Investigador(nombre, edad));

    }
}
