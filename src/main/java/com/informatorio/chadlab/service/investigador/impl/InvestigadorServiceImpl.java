package com.informatorio.chadlab.service.investigador.impl;

import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;
import com.informatorio.chadlab.service.investigador.InvestigadorService;
import com.informatorio.chadlab.utils.InputUtils;

import java.util.Comparator;

public class InvestigadorServiceImpl implements InvestigadorService {

    InvestigadorRepository investigadorRepository;

    public InvestigadorServiceImpl(InvestigadorRepository investigadorRepository) {
        this.investigadorRepository = investigadorRepository;
    }

    @Override
    public Investigador obtenerInvestigadorValido() {

        while (true){
            String nombreInvestigador = InputUtils.inputTexto("Ingrese el nombre del investigador");

            Investigador investigadorFiltrado = investigadorRepository.buscarInvestigadorPorNombre(nombreInvestigador);

            if (investigadorFiltrado != null) {
                return investigadorFiltrado;
            } else {
                System.out.println("El nombre ingresado no existe. Intente nuevamente");
            }
        }
    }

    @Override
    public Investigador mayorCantidadExperimentos() {
        return investigadorRepository.obtenerInvestigadores().stream()
                .max(Comparator.comparing(Investigador::getCantidadExperimentos))
                .orElse(null);
    }
}
