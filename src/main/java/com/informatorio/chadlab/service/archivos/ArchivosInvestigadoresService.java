package com.informatorio.chadlab.service.archivos;

import com.informatorio.chadlab.dominio.Investigador;

import java.util.List;

public interface ArchivosInvestigadoresService {

    void exportarCSV(List<Investigador> investigadores);

}
