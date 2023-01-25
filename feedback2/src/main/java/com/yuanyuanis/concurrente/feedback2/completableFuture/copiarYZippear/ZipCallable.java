package com.yuanyuanis.concurrente.feedback2.completableFuture.copiarYZippear;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCallable implements Callable<Path> {
    private String origenPath;
    private String destinoPath;

    public ZipCallable(String origenPath, String destinoPath) {
        this.origenPath = origenPath;
        this.destinoPath = destinoPath;
    }

    @Override
    public Path call() throws Exception {
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
