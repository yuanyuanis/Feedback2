package com.yuanyuanis.concurrente.feedback2.completableFuture.descargarFicheros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;

public class DescargarFicherosApp extends JFrame {

    private static final String FUTURE = "FUTURE";
    private static final String COMPLETABLE_FUTURE = "COMPLETABLE_FUTURE";

    private ButtonGroup group;
    private JTextField urlInputText;

    private void descargar(ActionEvent evt) {


        // 1) Validar datos de entrada.
        String optionSeleccionada = getOptionSeleccionada();

        if (optionSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Error: debes seleccionar una opción de implementación en la descarga.");
            return;
        }
        if (!validarURL(urlInputText.getText())) {
            JOptionPane.showMessageDialog(null, "Error: debes introducir una URL con datos de descarga validos.");
            return;
        }


        // 2) Gestión de la selección
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(DescargarFicherosApp.this);


        // 3) Invocar a la lógica de negocio.
        if (result == JFileChooser.APPROVE_OPTION) {

            String rutaGuardarFichero = fileChooser.getSelectedFile().getAbsolutePath();

            DescargarService service;
            if (optionSeleccionada.equals(COMPLETABLE_FUTURE)) {
                service = new DescargarServiceCompletableFutureImpl();
            } else if (optionSeleccionada.equals(FUTURE)) {
                service = new DescargarServiceFutureImpl();
            } else {
                String message = "Error inesperado, disculpa. Algo falla en la lógica de negocio";
                JOptionPane.showMessageDialog(null, message);
                return;
            }
            service.descargar(rutaGuardarFichero, urlInputText.getText());
        }
    }

    private String getOptionSeleccionada() {

        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getName();
            }
        }
        return null;
    }


    public boolean validarURL(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            return false;
        }
    }

    public DescargarFicherosApp() {
        initComponents();
    }

    private void initComponents() {


        JLabel titulo = new JLabel();
        JLabel subtitulo = new JLabel();

        JButton descargaButton = new JButton();
        urlInputText = new JTextField();

        JRadioButton futureRadioButton = new JRadioButton();
        JRadioButton completableFutureRadioButton = new JRadioButton();
        group = new ButtonGroup();
        group.add(futureRadioButton);
        group.add(completableFutureRadioButton);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setText("Bienvenido a la APP de descarga");

        futureRadioButton.setText("Implementación usando Future");
        futureRadioButton.setName(FUTURE);
        completableFutureRadioButton.setText("Implementación usando CompletableFuture");
        completableFutureRadioButton.setName(COMPLETABLE_FUTURE);

        descargaButton.setText("Descargar");


        descargaButton.addActionListener(this::descargar);

        subtitulo.setText("Introduzca una Url valida con el fichero a descargar");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(157, 157, 157)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(futureRadioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(completableFutureRadioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(subtitulo)
                                                        .addComponent(titulo)
                                                        .addComponent(urlInputText, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(208, 208, 208)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(urlInputText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(descargaButton))))
                                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(titulo)
                                .addGap(18, 18, 18)
                                .addComponent(futureRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(completableFutureRadioButton)
                                .addGap(34, 34, 34)
                                .addComponent(subtitulo)
                                .addGap(32, 32, 32)
                                .addComponent(urlInputText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(descargaButton)
                                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }

        EventQueue.invokeLater(() -> new DescargarFicherosApp().setVisible(true));
    }
}
