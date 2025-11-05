package com.informatorio.chadlab.service.experimento.impl;

import com.informatorio.chadlab.dominio.Experimento;
import com.informatorio.chadlab.repository.experimento.ExperimentoRepository;
import com.informatorio.chadlab.service.experimento.ExperimentoService;

import java.util.Comparator;
import java.util.List;

public class ExperimentoServiceImpl implements ExperimentoService {

    private ExperimentoRepository experimentoRepository;

    public ExperimentoServiceImpl(ExperimentoRepository experimentoRepository) {
        this.experimentoRepository = experimentoRepository;
    }

    @Override
    public void mostrarExperimentos() {

        List<Experimento> experimentos = this.experimentoRepository.obtenerExperimentos();

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
        } else {
            System.out.println("Aún no hay experimentos registrados\n");
        }
    }

    @Override
    public void mostrarEstadisticas() {

        List<Experimento> experimentos = this.experimentoRepository.obtenerExperimentos();

        if (!experimentos.isEmpty()) {
            int experimentosExitosos = contarExperimentosExitosos(experimentos);
            int experimentosFallidos = experimentos.size() - experimentosExitosos;

            System.out.println("ESTADÍSTICAS DE LOS EXPERIMENTOS\n");
            System.out.println("Total de experimentos: " + experimentos.size());
            System.out.printf(" - Total de experimentos exitosos: %d (%.2f%%)%n",
                    experimentosExitosos,
                    (double) experimentosExitosos*100/experimentos.size());
            System.out.printf(" - Total de experimentos exitosos: %d (%.2f%%)%n",
                    experimentosFallidos,
                    (double) experimentosFallidos*100/experimentos.size());
        } else {
            System.out.println("Aún no hay experimentos registrados\n");
        }

    }


    private int contarExperimentosExitosos(List<Experimento> experimentos) {
        int contador = 0;

        for (Experimento experimento : experimentos) {
            if (experimento.isExitoso()) {
                contador++;
            }
        }
        return contador;
    }


    @Override
    public Experimento mayorDuracion() {
        List<Experimento> experimentos = this.experimentoRepository.obtenerExperimentos();

        if (!experimentos.isEmpty()) {
            return experimentos.stream()
                    .max(Comparator.comparing(Experimento::getDuracion))
                    .orElse(null);
        }
        System.out.println("Aún no hay experimentos registrados\n");
        return null;
    }

}
