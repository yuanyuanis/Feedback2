package com.yuanyuanis.concurrente.feedback2.completableFuture.copiarYZippear;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipAndCopyCompletableFutureImpl implements ZipAndCopy{

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
            return ZipAndCopy.getZipAbsoluteName(origenPath, destinoPath);
        }).thenAccept(path -> {
            try {
                Files.copy(path, Paths.get(destinoPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


}
