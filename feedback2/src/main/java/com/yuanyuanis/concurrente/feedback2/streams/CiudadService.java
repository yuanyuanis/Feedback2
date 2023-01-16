package com.yuanyuanis.concurrente.feedback2.streams;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CiudadService {

    private final List<Ciudad> listaCiudades;

    public CiudadService(List<Ciudad> dataSet){
        this.listaCiudades = dataSet;
    }

    /**
     * 1. ¿De cuántas provincias diferentes son las ciudades?
     */
    public long getDistintasProvincias(){
        return listaCiudades.stream().filter(distinctByKey(Ciudad::getProvincia)).count();

    }
    /**
     * 2. ¿Cuántas ciudades hay?
     */
    public long getNumeroCiudades(){
        return listaCiudades.stream().count();
    }

    /**
     * 3. Calcula el número total de habitantes para una provincia determinada (introducida por el usuario, por ejemplo)
     */
    public int getNumeroHabitantesPorProvincia(String provincia){

        return listaCiudades.stream()
                .filter(c -> c.getProvincia().equalsIgnoreCase(provincia))
                .mapToInt(Ciudad::getPersonas)
                .sum();
    }

    /**
     * 4. Obtén una colección con los nombres de todas las ciudades
     */
    public List<String> getNombresCiudades(){
        return listaCiudades.stream()
                .map(Ciudad::getNombre)
                .collect(Collectors.toList());
    }

    /**
     * 5. Obtén una colección con los nombres de todas las provincias (sin repetir)
     */
    public List<String> getNombresProvinciasDistintas(){
        return listaCiudades.stream()
                .map(Ciudad::getProvincia)
                .distinct()
                .collect(Collectors.toList());

    }
    /**
     * 6. ¿Todas las ciudades son de más de 50.000 habitantes?
     */
    public List<Ciudad> getCiudadesConMasDeCincuentaMilHabitantes(){

        return listaCiudades.stream()
                .filter(c -> c.getPersonas()>50000)
                .collect(Collectors.toList());

    }

    /**
     * 7. ¿Alguna ciudad de una provincia determinada (introducida por el usuario) tiene más de 10.000 habitantes?
     */
    public List<Ciudad> getCiudadesConMasDiezMilHabitantesPorProvincia(String provincia){

        return listaCiudades.stream()
                .filter(c -> c.getPersonas() > 10000 && c.getProvincia().equalsIgnoreCase(provincia))
                .collect(Collectors.toList());

    }

    public static <Ciudad> Predicate<Ciudad> distinctByKey(Function<? super Ciudad, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public boolean validaExistenciaProvincia(String provincia) {

        return listaCiudades.stream()
                .anyMatch(ciudad -> ciudad.getProvincia().equalsIgnoreCase(provincia));
    }

    public List<Ciudad> getListaCiudades() {
        return listaCiudades;
    }
}
