package Vistas;

import Logica.AdministradorDeConsultas;
import Logica.AdministradorDeControl;
import Logica.AdministradorDeNiños;
import Logica.AdministradorDeVacunas;
import Logica.NiñoNoExistenteException;
import Logica.ResumenNiño;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

public class ListaNiños extends javax.swing.JFrame {

    private String documentSelected;

    private final AdministradorDeNiños administradorDeNiños;
    private final AdministradorDeConsultas administradorDeConsultas;
    private Object[][] niños;
    private final AdministradorDeControl administradorDeControles;
    private final AdministradorDeVacunas administradorDeVacunas;

    public ListaNiños(AdministradorDeNiños administradorDeNiño, AdministradorDeConsultas administradorDeConsultas, AdministradorDeControl administradorDeControles, AdministradorDeVacunas administradorDeVacunas) {

        this.administradorDeNiños = administradorDeNiño;
        this.administradorDeConsultas = administradorDeConsultas;
        this.administradorDeControles = administradorDeControles;
        this.administradorDeVacunas = administradorDeVacunas;

        recargarLista();

        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        jTableListaNiños.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            documentSelected = jTableListaNiños.getValueAt(jTableListaNiños.getSelectedRow(), 1).toString();
            jMenuItemEliminarNiño.setEnabled(true);
            jMenuItemModificarNiño.setEnabled(true);
            jMenuItemDetalle.setEnabled(true);
        });
    }

    private void recargarLista() {
        ArrayList<ResumenNiño> listadoDeNiños = this.administradorDeNiños.listar();
        this.niños = new Object[listadoDeNiños.size()][5];

        int index = 0;
        for (ResumenNiño niño : listadoDeNiños) {
            this.niños[index][0] = niño.getNombre();
            this.niños[index][1] = niño.getDocumento();
            this.niños[index][2] = niño.getServicioDeSalud();
            this.niños[index][3] = niño.getEdad();
            ++index;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListaNiños = new javax.swing.JTable();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItemDetalle = new javax.swing.JMenuItem();
        jMenuItemModificarNiño = new javax.swing.JMenuItem();
        jMenuItemEliminarNiño = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de niños");
        setName("listaNiñosFrame"); // NOI18N

        jTableListaNiños.setModel(new javax.swing.table.DefaultTableModel(
            this.niños,
            new String [] {
                "Nombre", "Documento", "Servicio de Salud", "Edad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableListaNiños);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar.add(jMenu1);

        jMenu2.setText("Niños");

        jMenuItem2.setText("Agregar nuevo niño");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItemDetalle.setText("Ver detalle");
        jMenuItemDetalle.setEnabled(false);
        jMenuItemDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDetalleActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemDetalle);

        jMenuItemModificarNiño.setText("Modificar niño");
        jMenuItemModificarNiño.setEnabled(false);
        jMenuItemModificarNiño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarNiñoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemModificarNiño);

        jMenuItemEliminarNiño.setText("Eliminar niño");
        jMenuItemEliminarNiño.setEnabled(false);
        jMenuItemEliminarNiño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarNiñoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemEliminarNiño);

        jMenuBar.add(jMenu2);

        jMenu4.setText("Ayuda");

        jMenuItem4.setText("Mas información");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar.add(jMenu4);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new AgregarNiño(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemModificarNiñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarNiñoActionPerformed
        try {
            new ModificarNiño(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas, this.documentSelected).setVisible(true);
            setVisible(false);
        } catch (NiñoNoExistenteException ex) {
            Logger.getLogger(ListaNiños.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemModificarNiñoActionPerformed

    private void jMenuItemEliminarNiñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarNiñoActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas eliminar este niño?");
        if (input == 0) {
            administradorDeNiños.eliminar(this.documentSelected);
            new ListaNiños(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jMenuItemEliminarNiñoActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new MasInformación().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItemDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDetalleActionPerformed
        try {
            new Detalle(administradorDeNiños, administradorDeConsultas, administradorDeControles, administradorDeVacunas, this.documentSelected).setVisible(true);
            setVisible(false);
        } catch (NiñoNoExistenteException ex) {
            Logger.getLogger(ListaNiños.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemDetalleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemDetalle;
    private javax.swing.JMenuItem jMenuItemEliminarNiño;
    private javax.swing.JMenuItem jMenuItemModificarNiño;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListaNiños;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
