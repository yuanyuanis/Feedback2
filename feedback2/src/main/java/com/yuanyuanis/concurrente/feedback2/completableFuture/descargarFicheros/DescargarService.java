package com.yuanyuanis.concurrente.feedback2.completableFuture.descargarFicheros;

import javax.swing.*;
import java.io.IOException;

public interface DescargarService {

    void descargar(String path, String ficheroUrl);

    static void mostrarResultado(String ficheroPath){
        try {

            // Si no podemos ejecutar el bloc de notas(es porque no está instalado en la máquina del usuario)
            // Le mostramos un bonito mensaje indicando que la operación ha finalizado.
            JOptionPane.showMessageDialog(null, "El fichero se descargo correctamente.");

            // Abrir el fichero para ver su contenido
            // Ejemplo: Abrir con el Bloc de notas
            Runtime.getRuntime().exec("notepad.exe " + ficheroPath);
        } catch (IOException e) {

            throw new RuntimeException("Problema de lógica");

        }
    }

}
