package com.informatorio.chadlab.dominio;

import com.informatorio.chadlab.repository.experimento.ExperimentoRepository;
import com.informatorio.chadlab.repository.experimento.impl.ExperimentoRepositoryImpl;
import com.informatorio.chadlab.repository.investigador.InvestigadorRepository;
import com.informatorio.chadlab.repository.investigador.impl.InvestigadorRepositoryImpl;
import com.informatorio.chadlab.service.experimento.ExperimentoService;
import com.informatorio.chadlab.service.experimento.impl.ExperimentoServiceImpl;
import com.informatorio.chadlab.service.input.InputExperimentoFisicoService;
import com.informatorio.chadlab.service.input.InputExperimentoQuimicoService;
import com.informatorio.chadlab.service.input.InputInvestigadorService;
import com.informatorio.chadlab.service.input.impl.InputExperimentoFisicoServiceImpl;
import com.informatorio.chadlab.service.input.impl.InputExperimentoQuimicoServiceImpl;
import com.informatorio.chadlab.service.input.impl.InputInvestigadorServiceImpl;
import com.informatorio.chadlab.service.investigador.InvestigadorService;
import com.informatorio.chadlab.service.investigador.impl.InvestigadorServiceImpl;

public class GestorLaboratorio {

    private InvestigadorRepository investigadorRepository = new InvestigadorRepositoryImpl();
    private InputInvestigadorService inputInvestigadorService = new InputInvestigadorServiceImpl(investigadorRepository);
    private ExperimentoRepository experimentoRepository = new ExperimentoRepositoryImpl();
    private InputExperimentoQuimicoService inputExperimentoQuimicoService = new InputExperimentoQuimicoServiceImpl(experimentoRepository);
    private InputExperimentoFisicoService inputExperimentoFisicoService = new InputExperimentoFisicoServiceImpl(experimentoRepository);
    private InvestigadorService investigadorService = new InvestigadorServiceImpl(investigadorRepository);
    private ExperimentoService experimentoService = new ExperimentoServiceImpl(experimentoRepository);

    public InvestigadorRepository getInvestigadorRepository() {
        return investigadorRepository;
    }

    public InputInvestigadorService getInputInvestigadorService() {
        return inputInvestigadorService;
    }

    public ExperimentoRepository getExperimentoRepository() {
        return experimentoRepository;
    }

    public InputExperimentoQuimicoService getInputExperimentoQuimicoService() {
        return inputExperimentoQuimicoService;
    }

    public InputExperimentoFisicoService getInputExperimentoFisicoService() {
        return inputExperimentoFisicoService;
    }

    public InvestigadorService getInvestigadorService() {
        return investigadorService;
    }

    public ExperimentoService getExperimentoService() {
        return experimentoService;
    }
}
