package com.informatorio.chadlab.repository.investigador.impl;

import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;

import java.util.ArrayList;
import java.util.List;

public class InvestigadorRepositoryImpl implements InvestigadorRepository {

    private List<Investigador> investigadores = new ArrayList<>();

    @Override
    public Investigador guardar(Investigador investigador) {
        investigadores.add(investigador);
        return investigador;
    }

    @Override
    public Investigador guardar(String nombre, int edad) {
        Investigador investigador = new Investigador(nombre, edad);
        return this.guardar(investigador);
    }

    @Override
    public List<Investigador> obtenerInvestigadores() {
        return this.getInvestigadores();
    }

    @Override
    public Investigador buscarInvestigadorPorNombre(String nombre) {
        return  investigadores.stream()
                .filter(investigador -> nombre.equalsIgnoreCase(investigador.getNombre()))
                .findFirst()
                .orElse(null);
    }

    //Getters
    public List<Investigador> getInvestigadores() {
        return investigadores;
    }
}
