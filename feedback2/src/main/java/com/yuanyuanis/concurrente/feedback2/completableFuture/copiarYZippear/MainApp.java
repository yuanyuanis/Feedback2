package com.yuanyuanis.concurrente.feedback2.completableFuture.copiarYZippear;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {

    private JButton origenButton;
    private JButton destinoButton;
    private JButton ejecutar;
    private JLabel titulo;
    private JTextField origenText;
    private JTextField destinoText;


    public MainApp() {
        initComponents();
    }

    private void seleccionarArchivoOrigen(ActionEvent e) {
        // 1) Gestión de la selección
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(MainApp.this);

        // 2) Invocar a la lógica de negocio.
        if (result == JFileChooser.APPROVE_OPTION) {

            String rutaGuardarFichero = fileChooser.getSelectedFile().getAbsolutePath();
            origenText.setText(rutaGuardarFichero);
        }
        intentarHabilitarEjecutar();
    }

    private void seleccionarArchivoDestino(ActionEvent e) {
        // 1) Gestión de la selección
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(MainApp.this);

        // 2) Invocar a la lógica de negocio.
        if (result == JFileChooser.APPROVE_OPTION) {

            String rutaGuardarFichero = fileChooser.getSelectedFile().getAbsolutePath();
            destinoText.setText(rutaGuardarFichero);
        }
        intentarHabilitarEjecutar();

    }

    private void intentarHabilitarEjecutar() {
        if (origenText.getText() != null && !origenText.getText().isEmpty()) {
            if (destinoText.getText() != null && !destinoText.getText().isEmpty()) {
                ejecutar.setEnabled(true);
            }
        }
    }

    private void copiar(ActionEvent evt) {
    }


    private void initComponents() {

        ejecutar = new JButton();
        origenButton = new JButton();
        destinoButton = new JButton();
        titulo = new JLabel();
        origenText = new javax.swing.JTextField();
        destinoText = new javax.swing.JTextField();

        origenText.setEnabled(false);
        destinoText.setEnabled(false);
        ejecutar.setEnabled(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        origenButton.setText("Seleccionar Origen");
        origenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarArchivoOrigen(e);
            }
        });

        destinoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarArchivoDestino(e);
            }
        });

        destinoButton.setText("Seleccionar Destino");
        destinoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                copiar(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo.setText("Bienvenido a Copiar y Zippear Directorios App");

        ejecutar.setText("Ejecutar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(155, 155, 155)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(origenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(destinoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(238, 238, 238)
                                                .addComponent(ejecutar)))
                                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(155, 155, 155)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(origenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(destinoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                                        .addComponent(origenText)
                                                        .addComponent(destinoText)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(242, 242, 242)
                                                .addComponent(ejecutar)))
                                .addContainerGap(79, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(titulo)
                                .addGap(42, 42, 42)
                                .addComponent(origenButton)
                                .addGap(24, 24, 24)
                                .addComponent(origenText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(destinoButton)
                                .addGap(18, 18, 18)
                                .addComponent(destinoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(ejecutar)
                                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }



    public static void main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {


            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }


}
