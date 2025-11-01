package com.informatorio.chadlab;

import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;
import com.informatorio.chadlab.repository.investigador.impl.InvestigadorRepositoryImpl;
import com.informatorio.chadlab.service.input.InputInvestigadorService;
import com.informatorio.chadlab.service.input.impl.InputInvestigadorServiceImpl;


public class App 
{
    public static void main( String[] args )
    {
        InvestigadorRepository investigadorRepository = new InvestigadorRepositoryImpl();
        InputInvestigadorService inputInvestigadorService = new InputInvestigadorServiceImpl(investigadorRepository);

        inputInvestigadorService.inputInvestigador();
    }
}
