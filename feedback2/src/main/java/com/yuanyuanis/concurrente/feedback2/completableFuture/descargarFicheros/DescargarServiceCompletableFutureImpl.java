package com.yuanyuanis.concurrente.feedback2.completableFuture.descargarFicheros;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.CompletableFuture;

public class DescargarServiceCompletableFutureImpl implements DescargarService{
    @Override
    public void descargar(String ficheroPath, String ficheroUrl) {
        // 1) Comienza la operación asíncrona de descarga
        CompletableFuture<Void> descargaTask = CompletableFuture.runAsync(() -> {
            try {
                URL url = new URL(ficheroUrl);
                Files.copy(url.openStream(), Paths.get(ficheroPath), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Fichero descargado en: " + ficheroPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        // Cuando se completa la tarea entonces podemos mostrar un mensaje de usuario indicando que la operación se ha realizado.
        descargaTask.thenRun(() -> DescargarService.mostrarResultado(ficheroPath));
    }
}
