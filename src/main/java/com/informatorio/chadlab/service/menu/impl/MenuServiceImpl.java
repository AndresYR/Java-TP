package com.informatorio.chadlab.service.menu.impl;

import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.repository.experimento.ExperimentoRepository;
import com.informatorio.chadlab.repository.experimento.impl.ExperimentoRepositoryImpl;
import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;
import com.informatorio.chadlab.repository.investigador.impl.InvestigadorRepositoryImpl;
import com.informatorio.chadlab.service.input.InputExperimentoQuimicoService;
import com.informatorio.chadlab.service.input.InputInvestigadorService;
import com.informatorio.chadlab.service.input.impl.InputExperimentoQuimicoServiceImpl;
import com.informatorio.chadlab.service.input.impl.InputInvestigadorServiceImpl;
import com.informatorio.chadlab.service.menu.MenuService;
import com.informatorio.chadlab.utils.InputUtils;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    public static final int REGISTRAR_INVESTIGADOR = 1;
    public static final int REGISTRAR_EXPERIMENTO = 2;
    public static final int MOSTRAR_INVESTIGADORES = 3;
    public static final int SALIR = 5;

    InvestigadorRepository investigadorRepository = new InvestigadorRepositoryImpl();
    InputInvestigadorService inputInvestigadorService = new InputInvestigadorServiceImpl(investigadorRepository);
    ExperimentoRepository experimentoRepository = new ExperimentoRepositoryImpl();
    InputExperimentoQuimicoService inputExperimentoQuimicoService = new InputExperimentoQuimicoServiceImpl(experimentoRepository);

    @Override
    public void seleccionar() {
        int opcion = 0;
        System.out.println("Bienvenido al Gestor de Laboratorio");

        do {
            System.out.println("Indique una opción:");
            System.out.println("1 - Registrar investigador");
            System.out.println("2 - Registrar experimento");
            System.out.println("3 - Mostrar investigadores");
            System.out.println("5 - Salir");

            opcion = InputUtils.inputIntPositivo("");
            this.ejecutar(opcion);

        } while (opcion != 5);
    }

    private void ejecutar(int opcion) {
        List<Investigador> investigadores = investigadorRepository.obtenerInvestigadores();

        switch (opcion) {
            case REGISTRAR_INVESTIGADOR -> {
                inputInvestigadorService.inputInvestigador();
            }

            case REGISTRAR_EXPERIMENTO -> {
                while (true) {
                    String nombreInvestigador = InputUtils.inputTexto("Ingrese el nombre del investigador");
                    Investigador investigadorFiltrado = investigadorRepository.buscarInvestigadorPorNombre(nombreInvestigador);
                    if (investigadorFiltrado != null) {
                        inputExperimentoQuimicoService.inputExperimentoQuimico(investigadorFiltrado);
                        break;
                    } else {
                        System.out.println("El nombre ingresado no existe. Intente nuevamente");
                    }
                }

            }

            case MOSTRAR_INVESTIGADORES -> {
                System.out.println("INVESTIGADORES:");
                for (int i = 0; i < investigadores.size(); i++) {
                    System.out.println(i+1 + " - " + investigadores.get(i).getNombre());
                }
            }

            default -> System.out.println("Ingrese una opción válida");
        }
    }
}
