package com.yuanyuanis.concurrente.feedback2.completableFuture.copiarYZippear;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompress {

    public static final String nombreZip = "\\archivo.zip";

    public static Path compress(String origenPath, String destinoPath) {
        final Path source = Paths.get(origenPath);
        final String nombreArchivoZip =origenPath+nombreZip;
        System.out.println(nombreArchivoZip);



        try {
            final ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(nombreArchivoZip));
            Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
                    try {
                        Path targetFile = source.relativize(file);
                        outputStream.putNextEntry(new ZipEntry(targetFile.toString()));
                        byte[] bytes = Files.readAllBytes(file);
                        outputStream.write(bytes, 0, bytes.length);
                        outputStream.closeEntry();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Paths.get(nombreArchivoZip);
    }

    public static void moveFile(Path src, Path dest) throws IOException {
        Files.move(src, dest, StandardCopyOption.REPLACE_EXISTING);
    }



}
