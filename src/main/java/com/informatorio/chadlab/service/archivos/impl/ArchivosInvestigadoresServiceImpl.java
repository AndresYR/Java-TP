package com.informatorio.chadlab.service.archivos.impl;

import com.informatorio.chadlab.dominio.Investigador;
import com.informatorio.chadlab.service.archivos.ArchivosInvestigadoresService;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivosInvestigadoresServiceImpl implements ArchivosInvestigadoresService {

    private final String UBICACION_ARCHIVO = "\\src\\main\\resources\\";
    private final String NOMBRE_ARCHIVO = "investigadores.csv";

    CSVWriter csvWriter;

    @Override
    public void exportarCSV(List<Investigador> investigadores) {

        String path = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat(NOMBRE_ARCHIVO);

        try {
            this.csvWriter = new CSVWriter(new FileWriter(path));

            String[] header = {"nombre", "edad", "cantidad_experimentos"};
            this.csvWriter.writeNext(header);

            for (Investigador investigador : investigadores) {
                String[] data = {investigador.getNombre(),
                        Integer.toString(investigador.getEdad()),
                        Integer.toString(investigador.getCantidadExperimentos())};
                this.csvWriter.writeNext(data);
            }

            System.out.println("Exportación exitosa!!!\n");
            this.cerrarWriter();

        } catch (IOException e) {
            System.out.println("Algo salio mal. Motivo: " + e.getMessage().concat("Ubicacion archivo: "+ path));
        }

    }

    private void cerrarWriter() {
        if (this.csvWriter != null) {
            try {
                this.csvWriter.close();
            } catch (IOException e) {
                System.out.println("Algo salio mal. Motivo: "+ e.getMessage());
            }
        }
    }
}
