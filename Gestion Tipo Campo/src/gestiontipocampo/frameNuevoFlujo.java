/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frameActividad.java
 *
 * Created on 16/06/2009, 08:39:38 AM
 */
package gestiontipocampo;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * Frame Actividad
 * @author Alberto
 */
public class frameNuevoFlujo extends javax.swing.JFrame {

    /** 
     * Constructor
     */
    public frameNuevoFlujo() {
        initComponents();

//        miActividad = new Actividad();
        todasActividades = new TreeSet();

        //Llena el combo con todas las actividades existentes
        llenarComboAAgregarActv();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonesRadioSecPar = new javax.swing.ButtonGroup();
        grupoBotonesRadioExOb = new javax.swing.ButtonGroup();
        labelNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        fieldDescripcion = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        botonAgregarComponente = new javax.swing.JButton();
        LlistaActividades = new javax.swing.JScrollPane();
        listaComponentes = new javax.swing.JList();
        labelAAgregar = new javax.swing.JLabel();
        comboComponenteAAgregar = new javax.swing.JComboBox();
        botonExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gestiontipocampo.GestionTipoCampoApp.class).getContext().getResourceMap(frameNuevoFlujo.class);
        labelNombre.setText(resourceMap.getString("labelNombre.text")); // NOI18N
        labelNombre.setMaximumSize(new java.awt.Dimension(10, 10));
        labelNombre.setMinimumSize(new java.awt.Dimension(10, 10));
        labelNombre.setName("labelNombre"); // NOI18N

        fieldNombre.setName("fieldNombre"); // NOI18N

        fieldDescripcion.setName("fieldDescripcion"); // NOI18N

        botonCancelar.setText(resourceMap.getString("botonCancelar.text")); // NOI18N
        botonCancelar.setName("botonCancelar"); // NOI18N
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAceptar.setText(resourceMap.getString("botonAceptar.text")); // NOI18N
        botonAceptar.setName("botonAceptar"); // NOI18N
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonAgregarComponente.setText(resourceMap.getString("botonAgregarComponente.text")); // NOI18N
        botonAgregarComponente.setName("botonAgregarComponente"); // NOI18N
        botonAgregarComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarComponenteActionPerformed(evt);
            }
        });

        LlistaActividades.setName("LlistaActividades"); // NOI18N

        listaComponentes.setName("listaComponentes"); // NOI18N
        LlistaActividades.setViewportView(listaComponentes);

        labelAAgregar.setText(resourceMap.getString("labelAAgregar.text")); // NOI18N
        labelAAgregar.setName("labelAAgregar"); // NOI18N

        comboComponenteAAgregar.setName("comboComponenteAAgregar"); // NOI18N
        comboComponenteAAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboComponenteAAgregarActionPerformed(evt);
            }
        });

        botonExcluir.setText(resourceMap.getString("botonExcluir.text")); // NOI18N
        botonExcluir.setName("botonExcluir"); // NOI18N
        botonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExcluirActionPerformed(evt);
            }
        });

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LlistaActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAgregarComponente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboComponenteAAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(fieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldDescripcion)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LlistaActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(comboComponenteAAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonAgregarComponente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(43, 43, 43)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarComboAAgregarActv() {
        javax.swing.DefaultComboBoxModel modelo = new javax.swing.DefaultComboBoxModel();
        modelo = (DefaultComboBoxModel) comboComponenteAAgregar.getModel();
        modelo.removeAllElements();
        Actividad tmp = new Actividad();
        Vector actividades = new Vector();
        actividades = tmp.getTodasLasActividades();
        int id;
        String nombreForm;
        for (int i = 0; i < actividades.size(); i++) {
            id = Integer.parseInt(actividades.get(i).toString());
            i++;
            nombreForm = actividades.get(i).toString();
            modelo.addElement(new MiDato(nombreForm, id));
        }
        comboComponenteAAgregar.setModel(modelo);
    }

   
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
//        miActividad.eliminar();
        this.dispose();
}//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        int size = listaComponentes.getModel().getSize();
        //Si se agregaron actividades, si no, no hace nada
        if (size > 0) {
            Object[] arregloActividades = todasActividades.toArray();
            String nombreFlujo = fieldNombre.getText();
            String descripcionFlujo = fieldDescripcion.getText();
            Actividad temp = ((Actividad)(arregloActividades[0]));

            //crea el flujo
            Flujo miFlujo = new Flujo(nombreFlujo, descripcionFlujo, temp.getCorrelativo());
            
            //Va actualizando todas las actividades para q se relacionen con el flujo
            miFlujo.actualizarActividad(temp.getCorrelativo(), miFlujo.getCorrelativo());
            for(int i = 1; i < size; ++i){
                temp = ((Actividad)(arregloActividades[i]));
                miFlujo.actualizarActividad(temp.getCorrelativo(), miFlujo.getCorrelativo());
            }
             //   miActividad.setEstadoInicial(listaComponentes.getModel().getElementAt(0).toString());
             //   miActividad.setEstadoInicial(listaComponentes.getModel().getElementAt(size - 1).toString());
            this.dispose();
        }



        /* COSAS VIEJAS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //Se guardan todos los datos en la BD
//        miActividad.setDescripcion(fieldDescripcion.getText());
//        miActividad.setNombre(fieldNombre.getText());
        
        //estos campos solo se guardan si existen valores agregados
        int size = listaComponentes.getModel().getSize();
        if (size > 0) {
         //   miActividad.setEstadoInicial(listaComponentes.getModel().getElementAt(0).toString());
         //   miActividad.setEstadoInicial(listaComponentes.getModel().getElementAt(size - 1).toString());
        }
//        miActividad.actualizar();
        this.dispose();
        */

        
}//GEN-LAST:event_botonAceptarActionPerformed

    private void botonAgregarComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarComponenteActionPerformed
        //Si se agregan Comandos
        int id = ((MiDato) (comboComponenteAAgregar.getSelectedItem())).ID;
        System.out.println("id: " + id);
        //Crea un objeto Actividada a partir d la actividad ya creada anterirmente
        Actividad tmp = new Actividad(id);
        
        //Se actualiza a cual flujo pertenece?¿ creo q no, hasta el final
        //tmp.setCorrelativoFlujo(id);
        //Agrega la actividad agregada a la lista de actividades, para q al final se relacionen con el flujo
        todasActividades.add(tmp);

        //miActividad.agregarActividadHija(tmp, 0, true /*TEMP*/);
        
        //Cambia los valores de la lista
        DefaultListModel modelo = new DefaultListModel();
        modelo.removeAllElements();
        int size = listaComponentes.getModel().getSize();
        for (int i = 0; i < size; ++i) {
            modelo.addElement(listaComponentes.getModel().getElementAt(i));
        }
        modelo.addElement(comboComponenteAAgregar.getSelectedItem());
        listaComponentes.setModel(modelo);
}//GEN-LAST:event_botonAgregarComponenteActionPerformed

    private void botonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExcluirActionPerformed
        Object dato = listaComponentes.getSelectedValue();
        DefaultListModel modelo = new DefaultListModel();
        modelo.removeAllElements();
        int size = listaComponentes.getModel().getSize();
        for (int i = 0; i < size; ++i) {
            //Mientras no sea el dato a excluir, copie
            if (!listaComponentes.getModel().getElementAt(i).equals(dato)) {
                modelo.addElement(listaComponentes.getModel().getElementAt(i));
            }
        }
        listaComponentes.setModel(modelo);
        //miActividad.desvincularActividad(new Actividad(((MiDato) (dato)).ID));
        todasActividades.remove(new Actividad(((MiDato) (dato)).ID));
    }//GEN-LAST:event_botonExcluirActionPerformed

    private void comboComponenteAAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboComponenteAAgregarActionPerformed
       /*
        //CREO Q ESTO NO ES NECESARIO. Beto
        if (((MiDato) comboComponenteAAgregar.getSelectedItem()) != null) {
            int idAct = ((MiDato) comboComponenteAAgregar.getSelectedItem()).ID;
            Actividad a = new Actividad(idAct);
            String desc = a.getDescripcion();
        }
*/
    }//GEN-LAST:event_comboComponenteAAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new frameActividad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane LlistaActividades;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAgregarComponente;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonExcluir;
    private javax.swing.JComboBox comboComponenteAAgregar;
    private javax.swing.JTextField fieldDescripcion;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.ButtonGroup grupoBotonesRadioExOb;
    private javax.swing.ButtonGroup grupoBotonesRadioSecPar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelAAgregar;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JList listaComponentes;
    // End of variables declaration//GEN-END:variables
    private Actividad miActividad;
    private SortedSet todasActividades;
}
