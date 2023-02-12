package com.yuanyuanis.concurrente.feedback2.completableFuture.copiarYZippear;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

public class ZipAndCopyServiceCompletableFutureImpl implements ZipAndCopyService {

    /**
     * Implementación de llamada asíncrona CompletableFuture
     * @param origenPath
     * @param destinoPath
     */
    @Override
    public void zippearYCopiar(String origenPath, String destinoPath) {


        // Extraída la tarea método estático en interfaz.
        // En sí, ZipAndCopy.getZipAbsoluteName(origenPath, destinoPath) representa el Callable.
        CompletableFuture.supplyAsync(() -> {
            return ZipCompressAndMove.compressAndMove(origenPath, destinoPath);
        }).thenAccept(path -> {
            try {
                Files.copy(path, Paths.get(destinoPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


}
