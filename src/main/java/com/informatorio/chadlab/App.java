package com.informatorio.chadlab;

import com.informatorio.chadlab.repository.experimento.ExperimentoRepository;
import com.informatorio.chadlab.repository.experimento.impl.ExperimentoRepositoryImpl;
import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;
import com.informatorio.chadlab.repository.investigador.impl.InvestigadorRepositoryImpl;
import com.informatorio.chadlab.service.input.InputExperimentoQuimicoService;
import com.informatorio.chadlab.service.input.InputInvestigadorService;
import com.informatorio.chadlab.service.input.impl.InputExperimentoQuimicoServiceImpl;
import com.informatorio.chadlab.service.input.impl.InputInvestigadorServiceImpl;


public class App 
{
    public static void main( String[] args )
    {
        InvestigadorRepository investigadorRepository = new InvestigadorRepositoryImpl();
        InputInvestigadorService inputInvestigadorService = new InputInvestigadorServiceImpl(investigadorRepository);
        ExperimentoRepository experimentoRepository = new ExperimentoRepositoryImpl();
        InputExperimentoQuimicoService inputExperimentoQuimicoService = new InputExperimentoQuimicoServiceImpl(experimentoRepository);

        inputInvestigadorService.inputInvestigador();
        inputExperimentoQuimicoService.inputExperimentoQuimico(investigadorRepository.obtenerInvestigadores().get(0));
        System.out.println(experimentoRepository.obtenerExperimentos().get(0).getNombre());
    }
}
