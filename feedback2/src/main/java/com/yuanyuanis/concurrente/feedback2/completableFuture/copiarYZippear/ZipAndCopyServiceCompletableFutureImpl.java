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
            return ZipCompress.compress(origenPath, destinoPath);
        }).thenAccept(path -> {
            try {
                ZipCompress.moveFile(path, Paths.get(destinoPath+ZipCompress.nombreZip));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        ZipAndCopyService.mostrarResultado("El Archivo se copio satisfactoriamente");
    }


}
