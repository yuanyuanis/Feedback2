package com.yuanyuanis.concurrente.feedback2.completableFuture.copiarYZippear;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public interface ZipAndCopy {

    void zippearYCopiar(String origenPath, String destinoPath);

    /**
     * Método que recibe una ruta origen y destino, comprime en zip y devuelve la ruta
     * devuelve la ruta destino donde queda el archivo comprimido
     * @param origenPath
     * @param destinoPath
     * @return Path
     */
    public static Path getZipAbsoluteName(String origenPath, String destinoPath) {
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
