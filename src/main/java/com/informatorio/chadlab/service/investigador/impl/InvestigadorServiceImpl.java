package com.informatorio.chadlab.service.investigador.impl;

import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;
import com.informatorio.chadlab.service.investigador.InvestigadorService;
import com.informatorio.chadlab.utils.InputUtils;

public class InvestigadorServiceImpl implements InvestigadorService {

    @Override
    public Investigador obtenerInvestigadorValido(InvestigadorRepository investigadorRepository) {

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
}
