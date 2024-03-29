/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frameBusqueda.java
 *
 * Created on 13-mar-2009, 19:45:31
 *
package gestiontipocampo;

import javax.swing.*;
//import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author Alberto
 */
public class frameBusquedaNodos extends javax.swing.JFrame {

    private frameEditarTerminos madre;

    /** Creates new form frameBusqueda */
    public frameBusquedaNodos() {
        initComponents();
    }

    /**
     * Constructor sobrecargado que recibe como parámetro el frame que lo invocó
     * @param frameMadre
     */
    public frameBusquedaNodos(frameEditarTerminos frameMadre) {
        initComponents();
        madre = frameMadre;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBusqueda = new javax.swing.JTable();
        botonOK = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tablaBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBusqueda.setName("tablaBusqueda"); // NOI18N
        tablaBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBusquedaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaBusquedaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBusqueda);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gestiontipocampo.GestionTipoCampoApp.class).getContext().getResourceMap(frameBusquedaNodos.class);
        tablaBusqueda.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tablaBusqueda.columnModel.title0")); // NOI18N
        tablaBusqueda.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tablaBusqueda.columnModel.title1")); // NOI18N
        tablaBusqueda.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tablaBusqueda.columnModel.title2")); // NOI18N

        botonOK.setText(resourceMap.getString("botonOK.text")); // NOI18N
        botonOK.setName("botonOK"); // NOI18N
        botonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOKActionPerformed(evt);
            }
        });

        botonCancelar.setText(resourceMap.getString("botonCancelar.text")); // NOI18N
        botonCancelar.setName("botonCancelar"); // NOI18N
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(299, 299, 299)
                        .add(botonCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(botonOK, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botonOK)
                    .add(botonCancelar))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOKActionPerformed
        realizarBusqueda();
        this.dispose();
    }//GEN-LAST:event_botonOKActionPerformed

    private void tablaBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBusquedaMouseEntered
}//GEN-LAST:event_tablaBusquedaMouseEntered

    private void tablaBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBusquedaMouseClicked
        if (evt.getClickCount() == 2) {
            realizarBusqueda();
            this.dispose();
        }

    }//GEN-LAST:event_tablaBusquedaMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    /**
     * Método que se encarga de llenar el dataGrid con los ids,nombres y descripciones de los nodos cuyos ids son enviados por parámetro
     * @param String[] ids
     * @param int cantElementos
     */
    public void llenarTabla(String[] ids, int cantElementos) {
        ControladorBD miPrueba = new ControladorBD();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) tablaBusqueda.getModel();

        Object[] fila = new Object[3];
        for (int i = 0; i < cantElementos; ++i) {
            try {
                ResultSet resultado = miPrueba.getResultSet("select * from NODO where ID = '" + ids[i] + "'");
                while (resultado.next()) {
                    fila[0] = resultado.getObject("ID").toString();
                    fila[1] = resultado.getObject("nombre").toString();
                    fila[2] = resultado.getObject("descripcion").toString();
                    //fila[3] = resultado.getObject("fechaUltimaModificacion").toString();
                    modelo.addRow(fila);
                }

            } catch (SQLException e) {
                System.out.println("*SQL Exception: *" + e.toString());
            }
        }
        tablaBusqueda.setModel(modelo);
        this.setVisible(true);
    }

    /**
     * Método que se encarga de llenar el dataGrid con los ids,nombres y descripciones de los nodos cuyos ids son enviados por parámetro y con un argumento de busqueda para filtrar los resultados
     * @param String[] ids
     * @param int cantElementos
     */
    public void llenarTablaBusqueda(String[] ids, String palabraClave, int cantElem) {
        ControladorBD miPrueba = new ControladorBD();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) tablaBusqueda.getModel();

        Object[] fila = new Object[3];
        for (int i = 0; i < cantElem; ++i) {
            try {
                ResultSet resultado = miPrueba.getResultSet("select * from NODO where ID = '" + ids[i] + "'");
                while (resultado.next()) {
                    if (palabraClave.equals(resultado.getObject("nombre").toString())) {
                        fila[0] = resultado.getObject("ID").toString();
                        fila[1] = resultado.getObject("nombre").toString();
                        fila[2] = resultado.getObject("descripcion").toString();
                        //fila[3] = resultado.getObject("fechaUltimaModificacion").toString();
                        modelo.addRow(fila);
                    }
                }

            } catch (SQLException e) {
                System.out.println("*SQL Exception: *" + e.toString());
            }
        }
        tablaBusqueda.setModel(modelo);
        this.setVisible(true);
    }

    /**
     *
     */
    private void realizarBusqueda() {
        int filaSeleccionada = tablaBusqueda.getSelectedRow();

        //JOptionPane.showMessageDialog(null, filaSeleccionada);
        if (filaSeleccionada != -1) {
            madre.setVisible(true);
            String llave = tablaBusqueda.getModel().getValueAt(filaSeleccionada, 0).toString();
        // madre.llenarFormularioCampos(llave);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frameBusqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonOK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaBusqueda;
    // End of variables declaration//GEN-END:variables
}
