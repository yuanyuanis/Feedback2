package com.yuanyuanis.concurrente.feedback2.completableFuture.copiarYZippear;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public interface ZipAndCopyService {

    void zippearYCopiar(String origenPath, String destinoPath);


    static void mostrarResultado(String ficheroPath) {

        JOptionPane.showMessageDialog(null, "Los ficheros se comprimieron correctamente.");
    }


}
