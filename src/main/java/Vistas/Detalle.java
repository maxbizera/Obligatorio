/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Dominio.Consulta;
import Logica.AdministradorDeConsultas;
import Logica.AdministradorDeControl;
import Logica.AdministradorDeNiños;
import Logica.AdministradorDeVacunas;
import Logica.Niño;
import Logica.NiñoNoExistenteException;
import Logica.ResumenConsulta;
import Logica.ResumenControl;
import Logica.ResumenVacuna;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author maxbi
 */
public class Detalle extends javax.swing.JFrame {

    private final AdministradorDeNiños administradorDeNiños;
    private final String documento;
    private String idControlSelected;
    private String idConsultaSelected;
    private String idVacunaSelected;
    private Object[][] consultas;
    private Object[][] controles;
    private Object[][] vacunas;
    private final AdministradorDeConsultas administradorDeConsultas;
    private final AdministradorDeControl administradorDeControles;
    private final AdministradorDeVacunas administradorDeVacunas;

    /**
     * Creates new form AgregarNiño
     */
    Detalle(AdministradorDeNiños administradorDeNiños, AdministradorDeConsultas administradorDeConsultas, AdministradorDeControl administradorDeControles, AdministradorDeVacunas administradorDeVacunas, String document) throws NiñoNoExistenteException {
        this.administradorDeNiños = administradorDeNiños;
        this.administradorDeConsultas = administradorDeConsultas;
        this.administradorDeControles = administradorDeControles;
        this.administradorDeVacunas = administradorDeVacunas;
        this.documento = document;

        Niño niño = administradorDeNiños.obtener(document);

        setTitle("Detalle del niño " + niño.getDocumento());
        
        ArrayList<ResumenConsulta> listadoDeConsultas = administradorDeConsultas.listar(documento);
        this.consultas = new Object[listadoDeConsultas.size()][3];

        int index1 = 0;
        for (ResumenConsulta consulta : listadoDeConsultas) {
            this.consultas[index1][0] = consulta.medico;
            this.consultas[index1][1] = consulta.diagnostico;
            this.consultas[index1][2] = consulta.recomendaciones;
            ++index1;
        }
        
        ArrayList<ResumenControl> listadoDeControles = administradorDeControles.listar(documento);
        this.controles = new Object[listadoDeControles.size()][2];

        int index2 = 0;
        for (ResumenControl control : listadoDeControles) {
            this.controles[index2][0] = control.peso;
            this.controles[index2][1] = control.altura;
            ++index2;
        }
        
        ArrayList<ResumenVacuna> listadoDeVacunas = administradorDeVacunas.listar(documento);
        this.vacunas = new Object[listadoDeVacunas.size()][3];

        int index3 = 0;
        for (ResumenVacuna vacuna : listadoDeVacunas) {
            this.vacunas[index3][0] = vacuna.nombre;
            this.vacunas[index3][1] = vacuna.dosis;
            this.vacunas[index3][2] = vacuna.obligatoria;
            ++index3;
        }
                
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        listarConsultas.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            idConsultaSelected = listarConsultas.getValueAt(listarConsultas.getSelectedRow(), 1).toString();
            btnEliminarConsulta.setEnabled(true);
        });
        listarControles.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            idControlSelected = listarControles.getValueAt(listarControles.getSelectedRow(), 1).toString();
            btnEliminarControl.setEnabled(true);
        });
        listarVacunas.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            idVacunaSelected = listarVacunas.getValueAt(listarVacunas.getSelectedRow(), 1).toString();
            btnEliminarVacuna.setEnabled(true);
        });
        
        this.txtDocumentoNiño.setText(niño.getDocumento());
        this.txtNombreNiño.setText(niño.getNombre());
        this.txtFonasa.setSelected(niño.getFonasa());
        this.txtMedicoCabezera.setText(niño.getMedicoCabezera());
        this.txtServicioMedico.setText(niño.getServicioMedico());
        this.txtNacimientoAño.setSelectedItem(niño.getFechaDeNacimiento().split("-")[0]);
        this.txtNacimientoMes.setSelectedItem(niño.getFechaDeNacimiento().split("-")[1]);
        this.txtNacimientoDia.setSelectedItem(niño.getFechaDeNacimiento().split("-")[2].split("T")[0]);

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
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listarConsultas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listarControles = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listarVacunas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnEliminarConsulta = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnEliminarControl = new javax.swing.JButton();
        btnEliminarVacuna = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

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
            txtNacimientoDia.addItem((i<10 ? "0" : "") + ""+i+"");
        }
        txtNacimientoDia.setEnabled(false);

        txtNacimientoMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Més", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
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

        jLabel6.setText("Lista de consultas");

        listarConsultas.setModel(new javax.swing.table.DefaultTableModel(
            this.consultas,
            new String [] {
                "Medico", "Diagnostico", "Recomendacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listarConsultas);

        jLabel7.setText("Lista de controles");

        listarControles.setModel(new javax.swing.table.DefaultTableModel(
            this.controles,
            new String [] {
                "Peso", "Altura"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(listarControles);

        jLabel8.setText("Lista de vacunas");

        listarVacunas.setModel(new javax.swing.table.DefaultTableModel(
            this.vacunas,
            new String [] {
                "Nombre", "Dosis", "Obligatorio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(listarVacunas);

        jButton1.setText("Agregar consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEliminarConsulta.setText("Eliminar consulta");
        btnEliminarConsulta.setEnabled(false);
        btnEliminarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarConsultaActionPerformed(evt);
            }
        });

        jButton5.setText("Agregar control");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnEliminarControl.setText("Eliminar control");
        btnEliminarControl.setEnabled(false);
        btnEliminarControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarControlActionPerformed(evt);
            }
        });

        btnEliminarVacuna.setText("Eliminar vacuna");
        btnEliminarVacuna.setEnabled(false);
        btnEliminarVacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVacunaActionPerformed(evt);
            }
        });

        jButton6.setText("Agregar vacuna");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNacimientoDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNacimientoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNacimientoAño, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFonasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(txtNombreNiño, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtDocumentoNiño))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(txtServicioMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtMedicoCabezera, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarVacuna)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarConsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarControl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreNiño, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocumentoNiño, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNacimientoDia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNacimientoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNacimientoAño, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFonasa))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServicioMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtMedicoCabezera, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton1)
                    .addComponent(btnEliminarConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(btnEliminarControl))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(btnEliminarVacuna))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ListaNiños(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            new ModificarNiño(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas, this.documento).setVisible(true);
            setVisible(false);
        } catch (NiñoNoExistenteException ex) {
            Logger.getLogger(ListaNiños.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas eliminar este niño?");
        if (input == 0) {
            administradorDeNiños.eliminar(this.documento);
            new ListaNiños(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas).setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AgregarConsulta(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas, this.documento).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarConsultaActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas eliminar este consulta?");
        if (input == 0) {
            //administradorDeNiños.eliminar(this.idConsultaSelected);
            new ListaNiños(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas).setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_btnEliminarConsultaActionPerformed

    private void btnEliminarControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarControlActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas eliminar este control?");
        if (input == 0) {
            //administradorDeNiños.eliminar(this.idControlSelected);
            new ListaNiños(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas).setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_btnEliminarControlActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new AgregarControl(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas, this.documento).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnEliminarVacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVacunaActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas eliminar esta vacuna?");
        if (input == 0) {
            //administradorDeNiños.eliminar(this.idVacunaSelected);
            new ListaNiños(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas).setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_btnEliminarVacunaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new AgregarVacuna(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas, this.documento).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarConsulta;
    private javax.swing.JButton btnEliminarControl;
    private javax.swing.JButton btnEliminarVacuna;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable listarConsultas;
    private javax.swing.JTable listarControles;
    private javax.swing.JTable listarVacunas;
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
