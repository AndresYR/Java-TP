package com.informatorio.chadlab.service.menu.impl;

import com.informatorio.chadlab.dominio.Experimento;
import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;
import com.informatorio.chadlab.service.archivos.ArchivosInvestigadoresService;
import com.informatorio.chadlab.service.archivos.impl.ArchivosInvestigadoresServiceImpl;
import com.informatorio.chadlab.service.experimento.ExperimentoService;
import com.informatorio.chadlab.service.input.InputExperimentoFisicoService;
import com.informatorio.chadlab.service.input.InputExperimentoQuimicoService;
import com.informatorio.chadlab.service.input.InputInvestigadorService;
import com.informatorio.chadlab.service.investigador.InvestigadorService;
import com.informatorio.chadlab.service.menu.MenuService;
import com.informatorio.chadlab.service.menu.SubMenuService;
import com.informatorio.chadlab.utils.InputUtils;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    private InvestigadorRepository investigadorRepository;
    private InputInvestigadorService inputInvestigadorService;
    private InputExperimentoQuimicoService inputExperimentoQuimicoService;
    private InputExperimentoFisicoService inputExperimentoFisicoService;
    private InvestigadorService investigadorService;
    private ExperimentoService experimentoService;
    private SubMenuService subMenuService;
    private ArchivosInvestigadoresService archivosInvestigadoresService;


    public MenuServiceImpl(InvestigadorRepository investigadorRepository,
                           InputInvestigadorService inputInvestigadorService,
                           InputExperimentoQuimicoService inputExperimentoQuimicoService,
                           InputExperimentoFisicoService inputExperimentoFisicoService,
                           InvestigadorService investigadorService,
                           ExperimentoService experimentoService) {
        this.investigadorRepository = investigadorRepository;
        this.inputInvestigadorService = inputInvestigadorService;
        this.inputExperimentoQuimicoService = inputExperimentoQuimicoService;
        this.inputExperimentoFisicoService = inputExperimentoFisicoService;
        this.investigadorService = investigadorService;
        this.experimentoService = experimentoService;
        this.subMenuService = new SubMenuServiceImpl(investigadorService, inputExperimentoQuimicoService, inputExperimentoFisicoService);
        this.archivosInvestigadoresService = new ArchivosInvestigadoresServiceImpl();
    }

    //Opciones
    public static final int REGISTRAR_INVESTIGADOR = 1;
    public static final int REGISTRAR_EXPERIMENTO = 2;
    public static final int MOSTRAR_INVESTIGADORES = 3;
    public static final int MOSTRAR_EXPERIMENTOS = 4;
    public static final int MOSTRAR_ESTADISTICAS = 5;
    public static final int MOSTRAR_EXPERIMENTO_MAYOR_DURACION = 6;
    public static final int REPORTE_CONSOLA = 7;
    public static final int MOSTRAR_INVESTIGADOR_MAS_EXPERIMENTOS = 8;
    public static final int EXPORTAR_INVESTIGADORES = 9;
    public static final int SALIR = 0;


    @Override
    public void seleccionar() {
        int opcion = 0;
        System.out.println("Bienvenido al Gestor de Laboratorio");

        do {
            System.out.println("Indique una opción:");
            System.out.println("1 - Registrar investigador");
            System.out.println("2 - Registrar experimento");
            System.out.println("3 - Mostrar investigadores");
            System.out.println("4 - Mostrar experimentos");
            System.out.println("5 - Mostrar estadísticas");
            System.out.println("6 - Mostrar experimento de mayor duración");
            System.out.println("7 - Generar reporte de experimentos por consola");
            System.out.println("8 - Mostrar investigador con más experimentos");
            System.out.println("9 - Exportar investigadores");
            System.out.println("0 - Salir");

            opcion = InputUtils.inputIntPositivo("");
            this.ejecutar(opcion);

        } while (opcion != SALIR);
    }

    private void ejecutar(int opcion) {

        switch (opcion) {
            case REGISTRAR_INVESTIGADOR -> {
                inputInvestigadorService.inputInvestigador();
            }

            case REGISTRAR_EXPERIMENTO -> {
                subMenuService.subMenuRegistrarExperimento();
            }

            case MOSTRAR_INVESTIGADORES -> {
                List<Investigador> investigadores = investigadorRepository.obtenerInvestigadores();

                System.out.println("INVESTIGADORES:");
                for (int i = 0; i < investigadores.size(); i++) {
                    System.out.println(i+1 + " - " + investigadores.get(i).getNombre());
                }
                System.out.println("\n");
            }

            case MOSTRAR_EXPERIMENTOS -> {
                experimentoService.mostrarExperimentos();
            }

            case MOSTRAR_ESTADISTICAS -> {
                experimentoService.mostrarEstadisticas();
            }

            case MOSTRAR_EXPERIMENTO_MAYOR_DURACION -> {
                Experimento mayorDuracion = experimentoService.mayorDuracion();
                if (mayorDuracion != null) {
                    System.out.println("EXPERIMENTO DE MAYOR DURACION");
                    System.out.printf("Tipo: %s - Nombre: %s - Duración: %d - Exito: %b%n",
                            mayorDuracion.getTipo(),
                            mayorDuracion.getNombre(),
                            mayorDuracion.getDuracion(),
                            mayorDuracion.isExitoso());
                    System.out.println("\n");
                }
            }

            case REPORTE_CONSOLA -> {
                experimentoService.reporte();
            }

            case MOSTRAR_INVESTIGADOR_MAS_EXPERIMENTOS -> {
                System.out.println("El investigador con mayor cantidad de experimentos es:");
                System.out.println(investigadorService.mayorCantidadExperimentos());
                System.out.println("\n");
            }

            case EXPORTAR_INVESTIGADORES -> {
                archivosInvestigadoresService.exportarCSV(investigadorRepository.obtenerInvestigadores());
            }


            case SALIR -> {
                System.out.println("Hasta luego!");
            }

            default -> System.out.println("Ingrese una opción válida");
        }
    }
}
