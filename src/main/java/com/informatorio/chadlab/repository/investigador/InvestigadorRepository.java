package com.informatorio.chadlab.repository.investigador;

import com.informatorio.chadlab.dominio.Investigador;

import java.util.List;

public interface InvestigadorRepository {

    Investigador guardar(Investigador investigador);

    Investigador guardar(String nombre, int edad);

    List<Investigador> obtenerInvestigadores();
}
