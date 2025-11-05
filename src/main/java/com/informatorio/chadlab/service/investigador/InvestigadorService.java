package com.informatorio.chadlab.service.investigador;

import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;

public interface InvestigadorService {

    Investigador obtenerInvestigadorValido();

    Investigador mayorCantidadExperimentos();

}
