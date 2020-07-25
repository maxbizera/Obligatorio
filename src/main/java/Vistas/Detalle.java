/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Logica.AdministradorDeNiños;
import Logica.Niño;
import Logica.NiñoNoExistenteException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author maxbi
 */
public class Detalle extends javax.swing.JFrame {

    private final AdministradorDeNiños administradorDeNiños;
    private final String documento;

    /**
     * Creates new form AgregarNiño
     */
    Detalle(AdministradorDeNiños administradorDeNiños, String document) throws NiñoNoExistenteException {
        this.administradorDeNiños = administradorDeNiños;
        this.documento = document;

        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        Niño niño = administradorDeNiños.obtener(document);
        this.txtDocumentoNiño.setText(niño.getDocumento());
        this.txtNombreNiño.setText(niño.getNombre());
        this.txtFonasa.setSelected(niño.getFonasa());
        this.txtMedicoCabezera.setText(niño.getMedicoCabezera());
        this.txtServicioMedico.setText(niño.getServicioMedico());
        this.txtNacimientoAño.setSelectedItem(niño.getFechaDeNacimiento().split("-")[0]);
        this.txtNacimientoMes.setSelectedItem(niño.getFechaDeNacimiento().split("-")[1]);
        this.txtNacimientoDia.setSelectedItem(niño.getFechaDeNacimiento().split("-")[2]);
        System.out.println("Vistas.Detalle.<init>() " + niño.getFonasa());

        setTitle("Detalle del niño " + niño.getDocumento());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreNiño = new javax.swing.JTextField();
        txtDocumentoNiño = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNacimientoDia = new javax.swing.JComboBox<>();
        txtNacimientoMes = new javax.swing.JComboBox<>();
        txtNacimientoAño = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtServicioMedico = new javax.swing.JTextField();
        txtMedicoCabezera = new javax.swing.JTextField();
        txtFonasa = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detalle del niño");

        jLabel1.setText("Nombre del niño");

        jLabel2.setText("Documento del niño");

        txtNombreNiño.setEnabled(false);

        txtDocumentoNiño.setEnabled(false);

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha de nacimiento");

        txtNacimientoDia.addItem("Día");
        for (int i = 1; i<=31; ++i) {
            txtNacimientoDia.addItem(""+i+"");
        }
        txtNacimientoDia.setEnabled(false);

        txtNacimientoMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Més", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        txtNacimientoMes.setEnabled(false);

        txtNacimientoAño.addItem("Año");
        for (int i = 2020; i>=1990; --i) {
            txtNacimientoAño.addItem(""+i+"");
        }
        txtNacimientoAño.setEnabled(false);

        jLabel4.setText("Servicio medico");

        jLabel5.setText("Medico de cabezera");

        txtServicioMedico.setEnabled(false);

        txtMedicoCabezera.setEnabled(false);

        txtFonasa.setText("¿Tiene fonasa?");
        txtFonasa.setEnabled(false);

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreNiño)
                            .addComponent(txtDocumentoNiño)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNacimientoDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNacimientoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNacimientoAño, 0, 102, Short.MAX_VALUE))
                            .addComponent(txtServicioMedico)
                            .addComponent(txtMedicoCabezera)
                            .addComponent(txtFonasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombreNiño, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDocumentoNiño, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtNacimientoDia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNacimientoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNacimientoAño))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(txtServicioMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMedicoCabezera, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(txtFonasa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ListaNiños(administradorDeNiños).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            new ModificarNiño(administradorDeNiños, this.documento).setVisible(true);
            setVisible(false);
        } catch (NiñoNoExistenteException ex) {
            Logger.getLogger(ListaNiños.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas eliminar este niño?");
        if (input == 0) {
            administradorDeNiños.eliminar(this.documento);
            new ListaNiños(administradorDeNiños).setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDocumentoNiño;
    private javax.swing.JCheckBox txtFonasa;
    private javax.swing.JTextField txtMedicoCabezera;
    private javax.swing.JComboBox<String> txtNacimientoAño;
    private javax.swing.JComboBox<String> txtNacimientoDia;
    private javax.swing.JComboBox<String> txtNacimientoMes;
    private javax.swing.JTextField txtNombreNiño;
    private javax.swing.JTextField txtServicioMedico;
    // End of variables declaration//GEN-END:variables
}
