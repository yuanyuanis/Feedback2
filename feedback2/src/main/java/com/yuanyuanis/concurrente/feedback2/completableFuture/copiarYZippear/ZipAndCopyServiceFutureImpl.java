package com.yuanyuanis.concurrente.feedback2.completableFuture.copiarYZippear;


import java.nio.file.Path;
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
            return ZipAndCopyService.getZipAbsoluteName(origenPath, destinoPath);
        };

        Future<Path> future = executor.submit(callable);

        // Esperar a que la tarea se complete
        try {
            Path path = future.get();                                               // hilo espera aquí a completarse
        } catch (Exception e){
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
