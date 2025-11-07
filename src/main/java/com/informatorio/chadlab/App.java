package com.informatorio.chadlab;

import com.informatorio.chadlab.dominio.GestorLaboratorio;
import com.informatorio.chadlab.service.menu.MenuService;
import com.informatorio.chadlab.service.menu.impl.MenuServiceImpl;


public class    App
{
    public static void main( String[] args )
    {

        GestorLaboratorio gestorLaboratorio = new GestorLaboratorio();

        MenuService menuService = new MenuServiceImpl(
                gestorLaboratorio.getInvestigadorRepository(),
                gestorLaboratorio.getInputInvestigadorService(),
                gestorLaboratorio.getInputExperimentoQuimicoService(),
                gestorLaboratorio.getInputExperimentoFisicoService(),
                gestorLaboratorio.getInvestigadorService(),
                gestorLaboratorio.getExperimentoService()
        );
        menuService.seleccionar();
    }
}
