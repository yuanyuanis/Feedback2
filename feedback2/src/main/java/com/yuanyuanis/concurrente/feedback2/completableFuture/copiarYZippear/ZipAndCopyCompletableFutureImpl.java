package com.yuanyuanis.concurrente.feedback2.completableFuture.copiarYZippear;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipAndCopyCompletableFutureImpl implements ZipAndCopy{
    @Override
    public void zipearYCopiar(String origenPath, String destinoPath) {
        CompletableFuture.supplyAsync(() -> {
            return getZipAbsuloteName(origenPath, destinoPath);
        }).thenAccept(path -> {
            try {
                Files.copy(path, Paths.get(destinoPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static Path getZipAbsuloteName(String origenPath, String destinoPath) {
        Path origen = Paths.get(origenPath);
        Path destino = Paths.get(destinoPath);

        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(destino))) {
            Files.walk(origen)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(origen.relativize(path).toString());
                        try {
                            zos.putNextEntry(zipEntry);
                            Files.copy(path, zos);
                            zos.closeEntry();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destino;
    }
}
