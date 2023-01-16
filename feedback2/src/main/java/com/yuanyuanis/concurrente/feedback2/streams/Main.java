package com.yuanyuanis.concurrente.feedback2.streams;

import java.util.Scanner;

public class Main {

    private static final CiudadService service = new CiudadService(CiudadDataSet.getBasicListaCiudades());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {

        while (true) {
            imprimirMenu();
            String option = scanner.nextLine();

            try {
                gestionarOptionUsuario(option);
            } catch (IllegalArgumentException e) {
                mostrarMensajeError(e.getMessage());
            }

        }
    }

    private static void gestionarOptionUsuario(String option) {

        switch (option) {
            case "1" -> {
                long numeroDistintasProvincias = service.getDistintasProvincias();
                System.out.println("\n\tRESPUESTA: El numero de provincias distintas del data_set es: " + numeroDistintasProvincias);
                presionaTeclaContinuar();
            }
            case "2" -> {
                long numeroCiudades = service.getNumeroCiudades();
                System.out.println("\n\tRESPUESTA: El numero de ciudades totales del data_set es: " + numeroCiudades);
                presionaTeclaContinuar();
            }
            case "3" -> {
                String provincia = getProvinciaValida();
                int resultado = service.getNumeroHabitantesPorProvincia(provincia);
                System.out.println("\n\tRESPUESTA: El numero de habitantes en la provincia " + provincia + " es: " + resultado);
                presionaTeclaContinuar();
            }
            case "4" -> {
                System.out.println("\n\tRESPUESTA: Los nombre de las ciudades son: " + service.getNombresCiudades());
                presionaTeclaContinuar();
            }
            case "5" -> {
                System.out.println("\n\tRESPUESTA: Los nombre de las provincias son: " + service.getNombresProvinciasDistintas());
                presionaTeclaContinuar();
            }
            case "6" -> {
                System.out.println("\n\tRESPUESTA: Las ciudades son de más de 50.000 del habitantes son: ");
                service.getCiudadesConMasDeCincuentaMilHabitantes()
                        .forEach(ciudad -> System.out.println("\t\t\t" + ciudad));
                presionaTeclaContinuar();
            }
            case "7" -> {
                String provincia2 = getProvinciaValida();
                System.out.println("\n\tRESPUESTA: Ciudades de la provincia '" + provincia2 + "' con más de 10.000 habitantes: ");
                service.getCiudadesConMasDiezMilHabitantesPorProvincia(provincia2)
                        .forEach(ciudad -> System.out.println("\t\t\t" + ciudad));
                presionaTeclaContinuar();
            }
            case "8" -> {
                System.out.println("---------------");
                System.out.println("Fin del programa");
                System.out.println("---------------");
                System.exit(0);
            }
            default -> {
                System.out.println("La opción: ('" + option + "') es invalida. Introduce correctamente de 1-8 las opciones de menú");
                presionaTeclaContinuar();
            }
        }
    }

    private static String getProvinciaValida() {

        while(true) {
            System.out.print("\tIntroduzca el nombre de la provincia: ");
            String nombreProvincia = scanner.nextLine();
            if(service.validaExistenciaProvincia(nombreProvincia)){
                return nombreProvincia;
            }else{
                System.out.println("\tERROR. La provincia introducida '"+nombreProvincia+"'+ no existe. Introduzca una provincia de las siguientes: " + service.getNombresProvinciasDistintas());
            }
        }
    }

    private static void mostrarMensajeError(String message) {
        System.out.println("\tERROR: " + message);
        presionaTeclaContinuar();
    }

    private static void presionaTeclaContinuar() {
        System.out.println("\tPresiona cualquier tecla para continuar ... ");
        scanner.nextLine();
    }

    private static void imprimirMenu() {

        System.out.println("\t----------------- Bienvenido al Menu del ejercicio Streams :-). ------------- ");

        // DATA SET
        System.out.println();
        service.getListaCiudades()
                .forEach(ciudad -> System.out.println("\t\t\t" + ciudad));
        System.out.println();

        // OPCIONES MENU
        System.out.println("\tDado el anterior DATA_SET, selecciona una de las siguientes opciones:");
        System.out.println("\t1. ¿De cuántas provincias diferentes son las ciudades?");
        System.out.println("\t2. ¿Cuántas ciudades hay?");
        System.out.println("\t3. Calcula el número total de habitantes para una provincia determinada");
        System.out.println("\t4. Obtén una colección con los nombres de todas las ciudades");
        System.out.println("\t5. Obtén una colección con los nombres de todas las provincias (sin repetir)");
        System.out.println("\t6. ¿Todas las ciudades son de más de 50.000 habitantes?");
        System.out.println("\t7. ¿Alguna ciudad de una provincia determinada tiene más de 10.000 habitantes?");
        System.out.println("\t8. Finalizar programa");
        System.out.println();
        System.out.print("\tIntroduce una opción(1-8): ");
    }


}
