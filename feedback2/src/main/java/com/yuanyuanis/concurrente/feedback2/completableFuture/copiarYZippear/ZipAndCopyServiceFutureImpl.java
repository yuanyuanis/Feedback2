package com.yuanyuanis.concurrente.feedback2.completableFuture.copiarYZippear;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ZipAndCopyServiceFutureImpl implements ZipAndCopyService {
    @Override
    public void zippearYCopiar(String origenPath, String destinoPath) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        // La tarea extraída a interfaz para evitar duplicidad de código
        Callable<Path> callable = () -> {
            return ZipCompress.compress(origenPath, destinoPath);
        };

        Future<Path> future = executor.submit(callable);

        // Esperar a que la tarea se complete
        try {
            Path path = future.get();                                               // hilo espera aquí a completarse

            // copiamos
            ZipCompress.moveFile(path, Paths.get(destinoPath+ZipCompress.nombreZip));
        } catch (Exception e){
            e.printStackTrace();
        }
        executor.shutdown();
        ZipAndCopyService.mostrarResultado("El Archivo se copio satisfactoriamente");
    }
}
