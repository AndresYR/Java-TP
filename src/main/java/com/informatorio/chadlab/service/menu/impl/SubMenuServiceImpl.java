package com.informatorio.chadlab.service.menu.impl;

import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.service.input.InputExperimentoFisicoService;
import com.informatorio.chadlab.service.input.InputExperimentoQuimicoService;
import com.informatorio.chadlab.service.investigador.InvestigadorService;
import com.informatorio.chadlab.service.menu.SubMenuService;
import com.informatorio.chadlab.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class SubMenuServiceImpl implements SubMenuService {

    public static final int REGISTRAR_EXPERIMENTO_QUIMICO = 1;
    public static final int REGISTRAR_EXPERIMENTO_FISICO = 2;
    public static final int VOLVER = 3;

    private InvestigadorService investigadorService;
    private InputExperimentoQuimicoService inputExperimentoQuimicoService;
    private InputExperimentoFisicoService inputExperimentoFisicoService;

    public SubMenuServiceImpl(InvestigadorService investigadorService,
                              InputExperimentoQuimicoService inputExperimentoQuimicoService,
                              InputExperimentoFisicoService inputExperimentoFisicoService) {
        this.investigadorService = investigadorService;
        this.inputExperimentoQuimicoService = inputExperimentoQuimicoService;
        this.inputExperimentoFisicoService = inputExperimentoFisicoService;
    }

    @Override
    public void subMenuRegistrarExperimento() {

        int opcion = 0;

        do {
            System.out.println("Seleccione el tipo de experimento que desea registrar:");
            System.out.println("1 - Registrar experimento químico");
            System.out.println("2 - Registrar experimento físico");
            System.out.println("3 - Volver al menu inicial");
            
            opcion = InputUtils.inputIntPositivo("");
            this.ejecutar(opcion);

        } while (opcion != VOLVER);
    }

    private void ejecutar(int opcion) {

        switch (opcion) {
            case REGISTRAR_EXPERIMENTO_QUIMICO -> {
                Investigador investigadorFiltrado = investigadorService.obtenerInvestigadorValido();
                inputExperimentoQuimicoService.inputExperimentoQuimico(investigadorFiltrado);
            }

            case REGISTRAR_EXPERIMENTO_FISICO -> {
                List<Investigador> investigadores = new ArrayList<>();
                while (true) {
                    int cantInvestigadores = InputUtils.inputIntPositivo("Ingrese el numero de investigadores:");

                    if (cantInvestigadores != 0) {
                        for (int i = 0; i < cantInvestigadores; i++) {
                            investigadores.add(investigadorService.obtenerInvestigadorValido());
                        }
                        inputExperimentoFisicoService.inputExperimentoFisico(investigadores);
                        break;
                    } else {
                        System.out.println("Ingrese un número distinto de 0");
                    }
                }

            }

            case VOLVER -> {
                break;
            }

            default -> System.out.println("Ingrese una opción válida");
        }

    }

}
