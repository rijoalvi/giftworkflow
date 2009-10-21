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
import javax.swing.JOptionPane;

/**
 * Frame Actividad
 * @author Alberto
 */
public class frameActividad extends javax.swing.JFrame {

    //Formulario a partir del cual se crea la actividad
    Formulario formularioActual;
    //Se usa para el orden de ejecuccion de los comandos o las actividades
    int orden;

    /** 
     * Constructor
     */
    public frameActividad() {
        initComponents();

        orden = 0;

        miActividad = new Actividad();
        miActividad.crearActividad();
        todasActividades = new TreeSet();
        todosComandos = new TreeSet();

        //Agrega los botones a un grupo de mutua exclusion
        grupoBotonesRadioSecPar.add(radioSecuencial);
        grupoBotonesRadioSecPar.add(radioEnParalelo);
        panelChecksParalelo.setVisible(false);

        grupoBotonesRadioExOb.add(radioObligatorio);
        grupoBotonesRadioExOb.add(radioExcluyente);

        //Llena el combo de los formularios
        llenarComboFormularios();

        //Por defecto se inicia una actividad simple
        //llenarCombosConComandos();
        comboComponenteAnterior.setVisible((false));
        labelLuegoDe.setVisible(false);
        labelDescripcion.setVisible(false);
        txtDescripcion.setVisible(false);
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
        labelTipo = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();
        labelDescripcion = new javax.swing.JLabel();
        fieldDescripcion = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        labelSeleccionFormulario = new javax.swing.JLabel();
        comboSeleccionFormulario = new javax.swing.JComboBox();
        labelLuegoDe = new javax.swing.JLabel();
        comboComponenteAnterior = new javax.swing.JComboBox();
        botonAgregarComponente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaComponentes = new javax.swing.JList();
        labelAAgregar = new javax.swing.JLabel();
        comboComponenteAAgregar = new javax.swing.JComboBox();
        cheackMasiva = new javax.swing.JCheckBox();
        panelChecksParalelo = new javax.swing.JPanel();
        radioExcluyente = new javax.swing.JRadioButton();
        radioObligatorio = new javax.swing.JRadioButton();
        checkRepetible = new javax.swing.JCheckBox();
        checkRequiereRevision = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        radioEnParalelo = new javax.swing.JRadioButton();
        radioSecuencial = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        LabelDescripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gestiontipocampo.GestionTipoCampoApp.class).getContext().getResourceMap(frameActividad.class);
        labelNombre.setText(resourceMap.getString("labelNombre.text")); // NOI18N
        labelNombre.setName("labelNombre"); // NOI18N

        fieldNombre.setName("fieldNombre"); // NOI18N

        labelTipo.setText(resourceMap.getString("labelTipo.text")); // NOI18N
        labelTipo.setName("labelTipo"); // NOI18N

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Simple", "Compuesta"} ));
        comboTipo.setName("comboTipo"); // NOI18N
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        labelDescripcion.setText(resourceMap.getString("labelDescripcion.text")); // NOI18N
        labelDescripcion.setName("labelDescripcion"); // NOI18N

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

        labelSeleccionFormulario.setText(resourceMap.getString("labelSeleccionFormulario.text")); // NOI18N
        labelSeleccionFormulario.setName("labelSeleccionFormulario"); // NOI18N

        comboSeleccionFormulario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        comboSeleccionFormulario.setName("comboSeleccionFormulario"); // NOI18N
        comboSeleccionFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSeleccionFormularioActionPerformed(evt);
            }
        });

        labelLuegoDe.setText(resourceMap.getString("labelLuegoDe.text")); // NOI18N
        labelLuegoDe.setName("labelLuegoDe"); // NOI18N

        comboComponenteAnterior.setName("comboComponenteAnterior"); // NOI18N

        botonAgregarComponente.setText(resourceMap.getString("botonAgregarComponente.text")); // NOI18N
        botonAgregarComponente.setName("botonAgregarComponente"); // NOI18N
        botonAgregarComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarComponenteActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        listaComponentes.setName("listaComponentes"); // NOI18N
        jScrollPane1.setViewportView(listaComponentes);

        labelAAgregar.setText(resourceMap.getString("labelAAgregar.text")); // NOI18N
        labelAAgregar.setName("labelAAgregar"); // NOI18N

        comboComponenteAAgregar.setName("comboComponenteAAgregar"); // NOI18N
        comboComponenteAAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboComponenteAAgregarActionPerformed(evt);
            }
        });

        cheackMasiva.setText(resourceMap.getString("cheackMasiva.text")); // NOI18N
        cheackMasiva.setName("cheackMasiva"); // NOI18N

        panelChecksParalelo.setName("panelChecksParalelo"); // NOI18N

        radioExcluyente.setText(resourceMap.getString("radioExcluyente.text")); // NOI18N
        radioExcluyente.setName("radioExcluyente"); // NOI18N

        radioObligatorio.setSelected(true);
        radioObligatorio.setText(resourceMap.getString("radioObligatorio.text")); // NOI18N
        radioObligatorio.setName("radioObligatorio"); // NOI18N

        javax.swing.GroupLayout panelChecksParaleloLayout = new javax.swing.GroupLayout(panelChecksParalelo);
        panelChecksParalelo.setLayout(panelChecksParaleloLayout);
        panelChecksParaleloLayout.setHorizontalGroup(
            panelChecksParaleloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChecksParaleloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChecksParaleloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioObligatorio)
                    .addComponent(radioExcluyente))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelChecksParaleloLayout.setVerticalGroup(
            panelChecksParaleloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChecksParaleloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioObligatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioExcluyente)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        checkRepetible.setText(resourceMap.getString("checkRepetible.text")); // NOI18N
        checkRepetible.setName("checkRepetible"); // NOI18N

        checkRequiereRevision.setText(resourceMap.getString("checkRequiereRevision.text")); // NOI18N
        checkRequiereRevision.setName("checkRequiereRevision"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        radioEnParalelo.setText(resourceMap.getString("radioEnParalelo.text")); // NOI18N
        radioEnParalelo.setName("radioEnParalelo"); // NOI18N
        radioEnParalelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEnParaleloActionPerformed(evt);
            }
        });

        radioSecuencial.setSelected(true);
        radioSecuencial.setText(resourceMap.getString("radioSecuencial.text")); // NOI18N
        radioSecuencial.setName("radioSecuencial"); // NOI18N
        radioSecuencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSecuencialActionPerformed(evt);
            }
        });

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        LabelDescripcion.setText(resourceMap.getString("LabelDescripcion.text")); // NOI18N
        LabelDescripcion.setName("LabelDescripcion"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setEnabled(false);
        txtDescripcion.setName("txtDescripcion"); // NOI18N
        jScrollPane2.setViewportView(txtDescripcion);

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
                                .addComponent(radioEnParalelo)
                                .addGap(29, 29, 29)
                                .addComponent(cheackMasiva)
                                .addGap(18, 18, 18)
                                .addComponent(checkRepetible)
                                .addGap(18, 18, 18)
                                .addComponent(checkRequiereRevision))
                            .addComponent(radioSecuencial)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelNombre)
                                            .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelTipo)))
                                    .addComponent(labelSeleccionFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboSeleccionFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelDescripcion))))
                        .addContainerGap(186, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelAAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboComponenteAAgregar, 0, 130, Short.MAX_VALUE)
                            .addComponent(labelLuegoDe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboComponenteAnterior, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonAgregarComponente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelChecksParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelDescripcion)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(152, 152, 152))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(751, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(labelSeleccionFormulario))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTipo)
                            .addComponent(labelDescripcion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSeleccionFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioSecuencial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioEnParalelo)
                    .addComponent(cheackMasiva)
                    .addComponent(checkRepetible)
                    .addComponent(checkRequiereRevision))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelChecksParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LabelDescripcion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelAAgregar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboComponenteAAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(labelLuegoDe)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboComponenteAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(botonAgregarComponente))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addGap(123, 123, 123))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        ((DefaultComboBoxModel) comboComponenteAAgregar.getModel()).removeAllElements();
        //Si se escogio tipo simple
        if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("Simple")) {
            comboSeleccionFormulario.setVisible(true);
            labelSeleccionFormulario.setVisible(true);
        //llena los combos con los valores de comandos
        //llenarCombosConComandos();
        } else {
            //Si se escogio tipo Compuesto
            if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("Compuesta")) {
                comboSeleccionFormulario.setVisible(false);
                labelSeleccionFormulario.setVisible(false);
                //llena los combos con los valores de comandos
                llenarCombosConActividades();
            }
        }
}//GEN-LAST:event_comboTipoActionPerformed

    /**
     * Llena los combos de agregar y anterior con Comandos(act simple)
     */
    private void llenarCombosConComandos(Vector comandos) {
        llenarComboAAgregarComando(comandos);
    //llenarComboAnteriorComando();
    }

    private void llenarComboAAgregarComando(Vector comandos) {
        javax.swing.DefaultComboBoxModel modelo = new javax.swing.DefaultComboBoxModel();
        modelo = (DefaultComboBoxModel) comboComponenteAAgregar.getModel();
        modelo.removeAllElements();
        Comando tmp = new Comando();
        /*Vector comandos = new Vector();
        comandos = tmp.getTodosLosComandos();*/
        int id;
        String nombreForm;
        for (int i = 0; i < comandos.size(); i++) {
            id = Integer.parseInt(comandos.get(i).toString());
            i++;
            nombreForm = comandos.get(i).toString();
            modelo.addElement(new MiDato(nombreForm, id));
        }
        comboComponenteAAgregar.setModel(modelo);
    }

    private void llenarComboAnteriorComando() {
        javax.swing.DefaultComboBoxModel modelo = new javax.swing.DefaultComboBoxModel();
        modelo = (DefaultComboBoxModel) comboComponenteAnterior.getModel();
        modelo.removeAllElements();
        Comando tmp = new Comando();
        Vector comandos = new Vector();
        comandos = tmp.getTodosLosComandos();
        int id;
        String nombreForm;
        for (int i = 0; i < comandos.size(); i++) {
            id = Integer.parseInt(comandos.get(i).toString());
            i++;
            nombreForm = comandos.get(i).toString();
            modelo.addElement(new MiDato(nombreForm, id));
        }
        comboComponenteAAgregar.setModel(modelo);
    }

    /**
     * Llena los combos de agregar y anterior con Actividades(act compuesta)
     */
    private void llenarCombosConActividades() {
        llenarComboAAgregarActv();
        llenarComboAnteriorActv();
    }

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

    private void llenarComboAnteriorActv() {
        javax.swing.DefaultComboBoxModel modelo = new javax.swing.DefaultComboBoxModel();
        modelo = (DefaultComboBoxModel) comboComponenteAnterior.getModel();
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
        miActividad.eliminar();
        this.dispose();
}//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        //Se guardan todos los datos en la BD
        miActividad.setDescripcion(fieldDescripcion.getText());
        miActividad.setMasiva(cheackMasiva.isSelected());
        miActividad.setNombre(fieldNombre.getText());
        miActividad.setRepetible(checkRepetible.isSelected());
        miActividad.setRequiereRevision(checkRequiereRevision.isSelected());
        miActividad.setSimple(comboTipo.getSelectedItem().toString().equalsIgnoreCase("Simple"));
        miActividad.setParalelo(radioEnParalelo.isSelected());
        miActividad.setExclusivo(radioExcluyente.isSelected());
        //Hmm no veo la diferencia entre es simple o tipo...¿?¿?¿?
        //¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?
        miActividad.setTipo(comboTipo.getSelectedIndex());

        //estos campos solo se guardan si existen valores agregados
        int size = listaComponentes.getModel().getSize();
        if (size > 0) {
            miActividad.setEstadoInicial(listaComponentes.getModel().getElementAt(0).toString());
            miActividad.setEstadoFinal(listaComponentes.getModel().getElementAt(size - 1).toString());
        }
        miActividad.actualizar();


        this.dispose();
}//GEN-LAST:event_botonAceptarActionPerformed

    /**
     * Llena el combo que contiene todos los formularios existentes
     */
    private void llenarComboFormularios() {
        javax.swing.DefaultComboBoxModel modelo = new javax.swing.DefaultComboBoxModel();
        modelo = (DefaultComboBoxModel) comboSeleccionFormulario.getModel();
        formularioActual = new Formulario();
        Vector forms = new Vector();
        forms = formularioActual.getTodosLosFormulario();
        int id;
        String nombreForm;
        for (int i = 0; i < forms.size(); i++) {
            id = Integer.parseInt(forms.get(i).toString());
            i++;
            nombreForm = forms.get(i).toString();
            modelo.addElement(new MiDato(nombreForm, id));
        }
        comboSeleccionFormulario.setModel(modelo);
    }

    private void botonAgregarComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarComponenteActionPerformed
        //Si se agregan Comandos
        if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("Simple")) {
            int id = ((MiDato) (comboComponenteAAgregar.getSelectedItem())).ID;
            Comando tmp = new Comando(id);
            //creo q hace falta un get miembro en la clase actividad...
            //y seria mejor tamb un get num Miembros...

            if(tmp.tipoComando == 1){ //si es comando de creacion
                MaestroDetalle md = new MaestroDetalle();
                int formularioACrear = md.IDDetalleDelMaestro(tmp.IDFormulario);// averiguar si el formulario es maestro
                if(formularioACrear != -1){//si el formulario era un maestro

                    //Agregar comando creacion del detalle
                    JOptionPane.showMessageDialog(null, "Debe agregar un comando de creacion del formulario detalle");
                    frameComandos comando = new frameComandos("Creacion",formularioACrear);
                    comando.setVisible(true);
                }else {
                    formularioACrear = md.IDMaestroDelDetalle(tmp.IDFormulario);// averiguar si el formulario es detalle
                    if(formularioACrear!=-1){
                        //agregar comando creacion del maestro
                        JOptionPane.showMessageDialog(null, "Debe agregar un comando de creacion del formulario Maestro");
                    }
                }


            }

            miActividad.agregarComando(tmp, orden, radioObligatorio.isSelected());
            orden++;
        } else {
            if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("Compuesta")) {
                int id = ((MiDato) (comboComponenteAAgregar.getSelectedItem())).ID;
                System.out.println("id> " + id);
                Actividad tmp = new Actividad(id);
                //Igual que arriba :p
                //creo q hace falta un get miembro en la clase actividad...
                //y seria mejor tamb un get num Miembros...
                miActividad.agregarActividadHija(tmp, orden, radioObligatorio.isSelected());
                orden++;
            }
        }
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

    private void radioEnParaleloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEnParaleloActionPerformed
        if (radioEnParalelo.isSelected()) {
            panelChecksParalelo.setVisible(true);
        } else {
            panelChecksParalelo.setVisible(false);
        }
    }//GEN-LAST:event_radioEnParaleloActionPerformed

    private void radioSecuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSecuencialActionPerformed
        if (radioSecuencial.isSelected()) {
            panelChecksParalelo.setVisible(false);
        } else {
            panelChecksParalelo.setVisible(true);
        }
    }//GEN-LAST:event_radioSecuencialActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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

        if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("Simple")) {
            miActividad.desvincularComando(new Comando(((MiDato) (dato)).ID));
        } else {
            if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("Compuesta")) {
                miActividad.desvincularActividad(new Actividad(((MiDato) (dato)).ID));
            }
        }

    /*
    DefaultListModel modelo = new DefaultListModel();
    modelo.removeAllElements();
    int size = listaComponentes.getModel().getSize();
    for(int i = 0; i < size; ++i){
    //Mientras no sea el dato a excluir, copie
    if( !listaComponentes.getModel().getElementAt(i).equals(dato) )
    modelo.addElement(listaComponentes.getModel().getElementAt(i));
    }
    modelo.addElement( comboComponenteAAgregar.getSelectedItem() );
    listaComponentes.setModel(modelo);
     */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboSeleccionFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSeleccionFormularioActionPerformed
        int idFormulario = ((MiDato) comboSeleccionFormulario.getSelectedItem()).ID;
        Comando com = new Comando();
        Vector comandosForm = com.getComandosFormulario(idFormulario);
        llenarCombosConComandos(comandosForm);

    }//GEN-LAST:event_comboSeleccionFormularioActionPerformed

    private void comboComponenteAAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboComponenteAAgregarActionPerformed

        if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("Simple")) {
            txtDescripcion.setVisible(false);
            labelDescripcion.setVisible(false);
            if (comboComponenteAAgregar.getSelectedItem() != null) {
                int idComando = ((MiDato) comboComponenteAAgregar.getSelectedItem()).ID;
                Comando com = new Comando(idComando);
                String des = com.getDescripcion() != null ? com.getDescripcion() : "";
                txtDescripcion.setText(des);
                txtDescripcion.setVisible(true);
                labelDescripcion.setVisible(true);
            }
        } else {
            if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("Compuesta")) {
                if (((MiDato) comboComponenteAAgregar.getSelectedItem()) != null) {
                    int idAct = ((MiDato) comboComponenteAAgregar.getSelectedItem()).ID;
                    Actividad a = new Actividad(idAct);
                    String desc = a.getDescripcion();
                    txtDescripcion.setText(desc);
                    txtDescripcion.setVisible(true);
                    labelDescripcion.setVisible(true);
                }
            }
        }

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
    private javax.swing.JLabel LabelDescripcion;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAgregarComponente;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JCheckBox cheackMasiva;
    private javax.swing.JCheckBox checkRepetible;
    private javax.swing.JCheckBox checkRequiereRevision;
    private javax.swing.JComboBox comboComponenteAAgregar;
    private javax.swing.JComboBox comboComponenteAnterior;
    private javax.swing.JComboBox comboSeleccionFormulario;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JTextField fieldDescripcion;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.ButtonGroup grupoBotonesRadioExOb;
    private javax.swing.ButtonGroup grupoBotonesRadioSecPar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAAgregar;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelLuegoDe;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSeleccionFormulario;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JList listaComponentes;
    private javax.swing.JPanel panelChecksParalelo;
    private javax.swing.JRadioButton radioEnParalelo;
    private javax.swing.JRadioButton radioExcluyente;
    private javax.swing.JRadioButton radioObligatorio;
    private javax.swing.JRadioButton radioSecuencial;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
    private Actividad miActividad;
    private SortedSet todasActividades;
    private SortedSet todosComandos;
}
