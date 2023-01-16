package com.yuanyuanis.concurrente.feedback2.streams;

import java.util.List;

public class CiudadDataSet {

    /**
     * DATA SET
     * Número de ciudades 16
     * Número de Provincias 2 (Cantabria, Asturias)
     */
    public static List<Ciudad> getBasicListaCiudades() {

        // CANTABRIA
        return List.of(new Ciudad("Cantabria", "Santoña", 11564),
                new Ciudad("Cantabria", "Santander", 180000),
                new Ciudad("Cantabria", "Torrelavega", 51000),
                new Ciudad("Cantabria", "Corrales de Balbuena", 10700),
                new Ciudad("Cantabria", "Escalante", 1110),
                new Ciudad("Cantabria", "Reinosa", 8946),
                new Ciudad("Cantabria", "Colindres", 8123),

                // ASTURIAS
                new Ciudad("Asturias", "Gijón", 272365),
                new Ciudad("Asturias", "Oviedo", 220301),
                new Ciudad("Asturias", "Aviles", 79514),
                new Ciudad("Asturias", "Ribadesella", 5779),
                new Ciudad("Asturias", "Pravia", 7430),
                new Ciudad("Asturias", "Cangas de Onis", 6332),
                new Ciudad("Asturias", "Llanes", 13759),
                new Ciudad("Asturias", "Langreo", 40529),
                new Ciudad("Asturias", "Cudillero", 5124)
        );
    }
}
