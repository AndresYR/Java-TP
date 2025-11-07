package com.informatorio.chadlab.service.investigador.impl;

import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;
import com.informatorio.chadlab.service.archivos.ArchivosInvestigadoresService;
import com.informatorio.chadlab.service.archivos.impl.ArchivosInvestigadoresServiceImpl;
import com.informatorio.chadlab.service.investigador.InvestigadorService;
import com.informatorio.chadlab.utils.InputUtils;

import java.util.Comparator;
import java.util.List;

public class InvestigadorServiceImpl implements InvestigadorService {

    private InvestigadorRepository investigadorRepository;
    private ArchivosInvestigadoresService archivosInvestigadoresService;
    private List<Investigador> investigadores;

    public InvestigadorServiceImpl(InvestigadorRepository investigadorRepository) {
        this.investigadorRepository = investigadorRepository;
        this.archivosInvestigadoresService = new ArchivosInvestigadoresServiceImpl();
        this.investigadores = investigadorRepository.obtenerInvestigadores();
    }


    @Override
    public Investigador obtenerInvestigadorValido() {

        while (true){
            String nombreInvestigador = InputUtils.inputTexto("Ingrese el nombre del investigador");

            Investigador investigadorFiltrado = this.investigadorRepository.buscarInvestigadorPorNombre(nombreInvestigador);

            if (investigadorFiltrado != null) {
                return investigadorFiltrado;
            } else {
                System.out.println("El nombre ingresado no existe. Intente nuevamente");
            }
        }
    }

    @Override
    public Investigador mayorCantidadExperimentos() {
        return this.investigadorRepository.obtenerInvestigadores().stream()
                .max(Comparator.comparing(Investigador::getCantidadExperimentos))
                .orElse(null);
    }

    @Override
    public void mostrarInvestigadores() {

        System.out.println("INVESTIGADORES:");
        for (int i = 0; i < this.investigadores.size(); i++) {
            System.out.println(i+1 + " - " + investigadores.get(i).getNombre());
        }
        System.out.println("\n");
    }

    @Override
    public void exportarCSV() {
        this.archivosInvestigadoresService.exportarCSV(this.investigadores);
    }
}
