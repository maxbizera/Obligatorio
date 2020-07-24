package Vistas;

import Logica.AdministradorDeNiños;
import Logica.ResumenNiño;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListaNiños extends javax.swing.JFrame {

    private final AdministradorDeNiños administradorDeNiños;
    private final Object[][] niños;

    public ListaNiños(AdministradorDeNiños administradorDeNiño) {

        this.administradorDeNiños = administradorDeNiño;

        this.niños = new Object[this.administradorDeNiños.listar().size()][5];

        int index = 0;
        for (ResumenNiño niño : this.administradorDeNiños.listar()) {
            this.niños[index][0] = niño.getNombre();
            this.niños[index][1] = niño.getDocumento();
            this.niños[index][2] = niño.getServicioDeSalud();
            this.niños[index][3] = niño.getEdad();
            ++index;
        }

        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListaNiños = new javax.swing.JTable();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItemModificarNiño = new javax.swing.JMenuItem();
        jMenuItemEliminarNiño = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de niños");
        setAlwaysOnTop(true);
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
        jMenu2.add(jMenuItemEliminarNiño);

        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new AgregarNiño().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemModificarNiñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarNiñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemModificarNiñoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemEliminarNiño;
    private javax.swing.JMenuItem jMenuItemModificarNiño;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListaNiños;
    // End of variables declaration//GEN-END:variables
}
