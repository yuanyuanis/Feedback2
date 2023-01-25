package com.yuanyuanis.concurrente.feedback2.completableFuture.descargarFicheros;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.*;

public class DescargarServiceFutureImpl implements DescargarService {

    @Override
    public void descargar(String path, String ficheroUrl) {


        ExecutorService executor = Executors.newSingleThreadExecutor();

        // La tarea
        Callable<Void> downloadTask = () -> {
            URL url = new URL(ficheroUrl);
            Files.copy(url.openStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            return null;
        };

        // Enviamos la tarea a ejecutar cuando al administrador de tareas le parezca bien.
        Future<Void> future = executor.submit(downloadTask);

        // Esperar a que la tarea se complete
        try {
            future.get();                                               // hilo espera aquí
            DescargarService.mostrarResultado(path);
        } catch (Exception e){
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
