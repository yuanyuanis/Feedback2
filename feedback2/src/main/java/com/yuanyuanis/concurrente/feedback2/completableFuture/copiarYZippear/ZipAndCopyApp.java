package com.yuanyuanis.concurrente.feedback2.completableFuture.copiarYZippear;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZipAndCopyApp extends JFrame {


    private JButton origenButton;
    private JButton destinoButton;
    private JButton ejecutar;
    private JLabel titulo;
    private JTextField origenText;
    private JTextField destinoText;


    public ZipAndCopyApp() {
        initComponents();
    }

    private void seleccionarDirectorioOrigen(ActionEvent e) {
        seleccionarDirectorio(true);
    }


    private void seleccionarDirectorioDestino(ActionEvent e) {
        seleccionarDirectorio(false);
    }

    private void seleccionarDirectorio(boolean origen) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showSaveDialog(ZipAndCopyApp.this);

        // 2) Invocar a la lógica de negocio.
        if (result == JFileChooser.APPROVE_OPTION) {

            String rutaGuardarFichero = fileChooser.getSelectedFile().getAbsolutePath();
            if(origen)
                origenText.setText(rutaGuardarFichero);
            else
                destinoText.setText(rutaGuardarFichero);
        }
        // Botón de ejecutar solo se habilita si origen y destino están establecidos.
        intentarHabilitarEjecutar();
    }

    private void intentarHabilitarEjecutar() {
        if (origenText.getText() != null && !origenText.getText().isEmpty()) {
            ejecutar.setEnabled(true);
        }
    }


    /**
     * Método que ejecuta la lógica de negocio de copiar
     * Descomentar la para elegir la implementación a probar
     *  - Future
     *  - CompletableFuture
     * @param evt
     */
    private void copiar(ActionEvent evt) {


        if(ejecutar.isEnabled()){
            // ------------------------------ DESCOMENTAR PARA ELEGIR IMPLEMENTACION --------------------------------/
            ZipAndCopyService service = new ZipAndCopyServiceFutureImpl();
            // ZipAndCopyService service = new ZipAndCopyServiceCompletableFutureImpl();
            service.zippearYCopiar(origenText.getText(), destinoText.getText());
        }


    }


    private void initComponents() {

        ejecutar = new JButton();
        origenButton = new JButton();
        destinoButton = new JButton();
        titulo = new JLabel();
        origenText = new JTextField();
        destinoText = new JTextField();

        destinoButton.setText("Seleccionar Destino");

        origenText.setEnabled(false);
        destinoText.setEnabled(false);
        ejecutar.setEnabled(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        origenButton.setText("Seleccionar Origen");


        origenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarDirectorioOrigen(e);
            }
        });

        destinoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarDirectorioDestino(e);
            }
        });

        ejecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                copiar(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo.setText("Bienvenido a Copiar y Zippear Directorios App");

        ejecutar.setText("Ejecutar");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(155, 155, 155)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(origenButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(titulo, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(destinoButton, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(238, 238, 238)
                                                .addComponent(ejecutar)))
                                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(titulo, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(155, 155, 155)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(origenButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(destinoButton, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                                        .addComponent(origenText)
                                                        .addComponent(destinoText)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(242, 242, 242)
                                                .addComponent(ejecutar)))
                                .addContainerGap(79, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(titulo)
                                .addGap(42, 42, 42)
                                .addComponent(origenButton)
                                .addGap(24, 24, 24)
                                .addComponent(origenText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(destinoButton)
                                .addGap(18, 18, 18)
                                .addComponent(destinoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
                new ZipAndCopyApp().setVisible(true);
            }
        });
    }

}
