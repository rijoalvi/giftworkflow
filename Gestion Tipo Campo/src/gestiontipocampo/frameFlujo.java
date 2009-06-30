/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frameFlujo.java
 *
 * Created on 28.06.2009, 17:40:04
 */
package gestiontipocampo;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class frameFlujo extends javax.swing.JFrame {

    /** Creates new form frameFlujo */
    public frameFlujo() {
        initComponents();
        flujo = null;
        actualizarCombos();
    }

    /**
     * Constructor que recibe correlativo del flujo.
     * @param correlativo
     */
    public frameFlujo(int correlativo) {
        initComponents();
        flujo = new Flujo(correlativo);
        actualizarCombos();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescripcionFlujo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        comboRaiz = new javax.swing.JComboBox();
        botonCerrar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        comboFlujos = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoDescripcionActividad = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gestiontipocampo.GestionTipoCampoApp.class).getContext().getResourceMap(frameFlujo.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        campoNombre.setText(resourceMap.getString("campoNombre.text")); // NOI18N
        campoNombre.setName("campoNombre"); // NOI18N
        campoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNombreFocusGained(evt);
            }
        });

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        campoDescripcionFlujo.setColumns(20);
        campoDescripcionFlujo.setRows(5);
        campoDescripcionFlujo.setName("campoDescripcionFlujo"); // NOI18N
        jScrollPane1.setViewportView(campoDescripcionFlujo);

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        comboRaiz.setModel(new javax.swing.DefaultComboBoxModel(new MiDato[] {new MiDato("", "", -1)}));
        comboRaiz.setName("comboRaiz"); // NOI18N
        comboRaiz.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboRaizPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        botonCerrar.setText(resourceMap.getString("botonCerrar.text")); // NOI18N
        botonCerrar.setName("botonCerrar"); // NOI18N
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        botonGuardar.setText(resourceMap.getString("botonGuardar.text")); // NOI18N
        botonGuardar.setName("botonGuardar"); // NOI18N
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        comboFlujos.setModel(new javax.swing.DefaultComboBoxModel(new MiDato[] {new MiDato("", "", -1)}));
        comboFlujos.setName("comboFlujos"); // NOI18N
        comboFlujos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboFlujosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        campoDescripcionActividad.setColumns(20);
        campoDescripcionActividad.setRows(5);
        campoDescripcionActividad.setEnabled(false);
        campoDescripcionActividad.setName("campoDescripcionActividad"); // NOI18N
        jScrollPane2.setViewportView(campoDescripcionActividad);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(comboFlujos, javax.swing.GroupLayout.Alignment.TRAILING, 0, 203, Short.MAX_VALUE)
                                    .addComponent(jLabel1)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(138, 138, 138)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(botonGuardar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(botonCerrar))
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboRaiz, 0, 203, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFlujos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboRaiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCerrar)
                    .addComponent(botonGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if(!campoNombre.getText().isEmpty() && ((MiDato)comboRaiz.getSelectedItem()).ID >= 0){
            flujo = new Flujo(campoNombre.getText(), campoDescripcionFlujo.getText(), new Actividad(((MiDato)comboRaiz.getSelectedItem()).ID));
        }
        else{
            JOptionPane.showMessageDialog(this, "Hay Campos sin llenar ó la Actividad raíz no está seleccionada!");
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void comboFlujosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboFlujosPopupMenuWillBecomeInvisible
        flujo = new Flujo(((MiDato)comboFlujos.getSelectedItem()).ID);
        int ID = flujo.getRaiz().getCorrelativo();
        campoDescripcionFlujo.setText(((MiDato)comboFlujos.getSelectedItem()).descripcion);
        campoNombre.setText(((MiDato)comboFlujos.getSelectedItem()).nombre);
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)comboRaiz.getModel();
        MiDato dato = (MiDato)modelo.getElementAt(0);
        for(int i = 1; i < modelo.getSize(); i++){
            if(((MiDato)modelo.getElementAt(i)).ID == ID){
                dato = (MiDato)modelo.getElementAt(i);
                i = modelo.getSize();
            }
        }
        comboRaiz.setSelectedItem(dato);
    }//GEN-LAST:event_comboFlujosPopupMenuWillBecomeInvisible

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void comboRaizPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboRaizPopupMenuWillBecomeInvisible
        campoDescripcionActividad.setText(((MiDato)comboRaiz.getSelectedItem()).descripcion);
    }//GEN-LAST:event_comboRaizPopupMenuWillBecomeInvisible

    private void campoNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreFocusGained

    /**
     * Carga los datos en los combos
     */
    public void actualizarCombos(){
        cargarComboFlujo();
        cargarComboActividad();
    }

    /**
     * Carga los datos en el combo de Flujos
     */
    private void cargarComboFlujo(){
        ControladorBD buscador = new ControladorBD();
        Vector<MiDato> datos = buscador.getFlujos();
        javax.swing.DefaultComboBoxModel modelo = (DefaultComboBoxModel)comboFlujos.getModel();
        modelo.removeAllElements();
        modelo.addElement(new MiDato("", -1));
        for(int i = 0; i < datos.size(); ++i){
            modelo.addElement(datos.get(i));
        }
        comboFlujos.setModel(modelo);
    }

    /**
     * Carga los datos en el combo de Actividades
     */
    private void cargarComboActividad(){
        ControladorBD buscador = new ControladorBD();
        Vector<MiDato> datos = buscador.getActividades();
        javax.swing.DefaultComboBoxModel modelo = (DefaultComboBoxModel)comboRaiz.getModel();
        modelo.removeAllElements();
        modelo.addElement(new MiDato("", -1));
        for(int i = 0; i < datos.size(); ++i){
            modelo.addElement(datos.get(i));
        }
        comboRaiz.setModel(modelo);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new frameFlujo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextArea campoDescripcionActividad;
    private javax.swing.JTextArea campoDescripcionFlujo;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox comboFlujos;
    private javax.swing.JComboBox comboRaiz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    private Flujo flujo;
}