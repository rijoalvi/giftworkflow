/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SeleccionFormulario.java
 *
 * Created on 25/05/2009, 03:04:57 PM
 */
package gestiontipocampo;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ea63183
 */
public class SeleccionComando extends javax.swing.JFrame {

    frameComandos madre;

    /** Creates new form SeleccionFormulario */
    public SeleccionComando() {
        initComponents();
        llenarTabla();
    }

    /*public SeleccionComando(frameFormulario frameMadre, JTree arbolPrincipal) {
    initComponents();
    madre = frameMadre;
    this.arbolPrincipal = arbolPrincipal;
    }*/
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonCancelar = new javax.swing.JButton();
        botonOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBusqueda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gestiontipocampo.GestionTipoCampoApp.class).getContext().getResourceMap(SeleccionComando.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        botonCancelar.setText(resourceMap.getString("botonCancelar.text")); // NOI18N
        botonCancelar.setName("botonCancelar"); // NOI18N
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonOK.setText(resourceMap.getString("botonOK.text")); // NOI18N
        botonOK.setName("botonOK"); // NOI18N
        botonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOKActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tablaBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Incremental", "Nombre", "Nota", "Fecha última actualización"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        tablaBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaBusquedaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBusqueda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonOK)
                    .addComponent(botonCancelar))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
}//GEN-LAST:event_botonCancelarActionPerformed

    private void botonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOKActionPerformed
        realizarBusqueda();
        this.dispose();
}//GEN-LAST:event_botonOKActionPerformed

    private void tablaBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBusquedaMouseClicked
        if (evt.getClickCount() == 2) {
            realizarBusqueda();
            this.dispose();
        }
    }//GEN-LAST:event_tablaBusquedaMouseClicked

    private void tablaBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBusquedaMouseEntered
}//GEN-LAST:event_tablaBusquedaMouseEntered

    private void tablaBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaBusquedaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            realizarBusqueda();
            this.dispose();
        }
    }//GEN-LAST:event_tablaBusquedaKeyPressed

    /**
     * Llena la el data grid con los comandos que se encuentren la base de datos
     */
    public void llenarTabla() {
        ControladorBD miPrueba = new ControladorBD();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) tablaBusqueda.getModel();

        Object[] fila = new Object[4];
        //       madre.setVisible(false);
        try {
            ResultSet resultado = miPrueba.getResultSet("select ID, Nombre, Descripcion, FechaActualizacion from COMANDO;");
            while (resultado.next()) {
                for (int i = 0; i < 4; i++) {
                    fila[i] = resultado.getObject(i + 1).toString();
                }
                modelo.addRow(fila);
            }
            tablaBusqueda.setModel(modelo);

        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
    }

    /**
     * Abre un formulario de FrameComandos con el valor seleccionado en el dataGrid
     */
    public void realizarBusqueda() {
        int filaSeleccionada = tablaBusqueda.getSelectedRow();

        //JOptionPane.showMessageDialog(null, filaSeleccionada);
        if (filaSeleccionada != -1) {
            int llave = Integer.parseInt(tablaBusqueda.getModel().getValueAt(filaSeleccionada, 0).toString());
            madre = new frameComandos(llave);
            madre.setVisible(true);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SeleccionComando().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonOK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaBusqueda;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JTree arbolPrincipal;
}
