package com.informatorio.chadlab.service.experimento.impl;

import com.informatorio.chadlab.dominio.Experimento;
import com.informatorio.chadlab.repository.experimento.ExperimentoRepository;
import com.informatorio.chadlab.service.experimento.ExperimentoService;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

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
            System.out.printf("%-20s%-40s%-20s%-20s%-30s%n","Tipo","Nombre", "Duración", "Exito", "Reactivo/Instrumento");

            for (Experimento experimento : experimentos) {
                System.out.println(experimento.toString());
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

    @Override
    public void reporte() {
        List<Experimento> experimentos = this.experimentoRepository.obtenerExperimentos();

        if (!experimentos.isEmpty()) {
            int experimentosExitosos = contarExperimentosExitosos(experimentos);
            double promedio = this.duracionPromedio(experimentos);

            System.out.printf("La duración promedio de los experimentos es de %.2f minutos%n", promedio);
            System.out.printf("El porcentaje de exito global es de %.2f%%%n",
                    (double) experimentosExitosos*100/experimentos.size());


        } else {
            System.out.println("Aún no hay experimentos registrados\n");
        }
    }

    private double duracionPromedio(List<Experimento> experimentos) {
        IntStream duracionStream = experimentos.stream()
                .mapToInt(Experimento::getDuracion);
        OptionalDouble promedio = duracionStream.average();
        return promedio.getAsDouble();
    }


}
