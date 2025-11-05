package com.informatorio.chadlab.service.experimento.impl;

import com.informatorio.chadlab.dominio.Experimento;
import com.informatorio.chadlab.repository.experimento.ExperimentoRepository;
import com.informatorio.chadlab.service.experimento.ExperimentoService;

import java.util.List;

public class ExperimentoServiceImpl implements ExperimentoService {
    @Override
    public void mostrarExperimentos(ExperimentoRepository experimentoRepository) {

        List<Experimento> experimentos = experimentoRepository.obtenerExperimentos();

        if (!experimentos.isEmpty()) {
            System.out.println("LISTADO DE EXPERIMENTOS\n");
            System.out.printf("%-20s%-40s%-20s%-20s%n","Tipo","Nombre", "Duración", "Exito");

            for (Experimento experimento : experimentos) {
                String exito = (experimento.isExitoso()) ? "Si":"No";
                System.out.printf("%-20s%-40s%-20d%-20s%n",
                        experimento.getTipo(),
                        experimento.getNombre(),
                        experimento.getDuracion(),
                        exito);
            }
            System.out.println("\n\n");
        }

        System.out.println("Aún no hay experimentos registrados\n\n");

    }
}
