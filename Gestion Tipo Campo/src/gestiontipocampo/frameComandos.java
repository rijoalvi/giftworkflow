/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frameComandos.java
 *
 * Created on 24/05/2009, 10:19:33 PM
 */
package gestiontipocampo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import java.util.*;

/**
 *
 * @author Ricardo
 */
public class frameComandos extends javax.swing.JFrame {



    /** Creates new form frameComandos */
    Comando comandoActual;
    int ConMascara=0;
    Formulario formularioActual;
    /******esta es para saber cual es el correlativo del i-esimo elemento del comboBox******/
    Vector correlativo;


    Vector IDEtiquetaCampo;//tipoCapo de las etiquetas que tienen campos asociados en el mismo orden en el que se encuentran cargadas las  etiquetas  en el comboBox




    /*Constructro con el que inicia todo en blanco*/
    public frameComandos() {
        initComponents();
        comboListaCondicion.setVisible(false);
        comboListaEfecto.setVisible(false);
        ocultarCamposConMascara();
        comandoActual = new Comando(); // Clase comando con la que trabajara la interfaz!
        llenarComboFormularios();


    /*comboSeleccionFormulario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));*/
    }

    /*Constructor que recive el correlativo del formulario con el que iniciara*/
    public frameComandos(int correlativoComando) {
        initComponents();
        comboListaCondicion.setVisible(false);
        comboListaEfecto.setVisible(false);
        ocultarCamposConMascara();
        comandoActual = new Comando(correlativoComando); // Clase comando con la que trabajara la interfaz!
        llenarComboFormularios();
        fieldNombre.setText(comandoActual.getNombre());
        fieldDescripcion.setText(comandoActual.getDescripcion());
        comboTipo.setSelectedIndex(comandoActual.getTipoComando()-1);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        labelTipo = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();
        labelDescripcion = new javax.swing.JLabel();
        fieldDescripcion = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        labelCondicionInicial = new javax.swing.JLabel();
        labelSeleccionFormulario = new javax.swing.JLabel();
        comboSeleccionFormulario = new javax.swing.JComboBox();
        labelCampoInicial = new javax.swing.JLabel();
        comboCampoInicial = new javax.swing.JComboBox();
        fieldAccion = new javax.swing.JTextField();
        labelCampoFinal = new javax.swing.JLabel();
        comboCampoFinal = new javax.swing.JComboBox();
        labelCondFinal = new javax.swing.JLabel();
        fieldEfecto = new javax.swing.JTextField();
        comboListaCondicion = new javax.swing.JComboBox();
        comboListaEfecto = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        labelNombre.setLabelFor(fieldNombre);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gestiontipocampo.GestionTipoCampoApp.class).getContext().getResourceMap(frameComandos.class);
        labelNombre.setText(resourceMap.getString("labelNombre.text")); // NOI18N
        labelNombre.setName("labelNombre"); // NOI18N

        fieldNombre.setText(resourceMap.getString("fieldNombre.text")); // NOI18N
        fieldNombre.setName("fieldNombre"); // NOI18N

        labelTipo.setLabelFor(comboTipo);
        labelTipo.setText(resourceMap.getString("labelTipo.text")); // NOI18N
        labelTipo.setName("labelTipo"); // NOI18N

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crear", "Eliminar", "Modificar", "Comando con Máscara" }));
        comboTipo.setName("comboTipo"); // NOI18N
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        labelDescripcion.setLabelFor(fieldDescripcion);
        labelDescripcion.setText(resourceMap.getString("labelDescripcion.text")); // NOI18N
        labelDescripcion.setName("labelDescripcion"); // NOI18N

        fieldDescripcion.setText(resourceMap.getString("fieldDescripcion.text")); // NOI18N
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

        labelCondicionInicial.setText(resourceMap.getString("labelCondicionInicial.text")); // NOI18N
        labelCondicionInicial.setName("labelCondicionInicial"); // NOI18N

        labelSeleccionFormulario.setLabelFor(comboSeleccionFormulario);
        labelSeleccionFormulario.setText(resourceMap.getString("labelSeleccionFormulario.text")); // NOI18N
        labelSeleccionFormulario.setName("labelSeleccionFormulario"); // NOI18N

        comboSeleccionFormulario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        comboSeleccionFormulario.setName("comboSeleccionFormulario"); // NOI18N
        comboSeleccionFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSeleccionFormularioActionPerformed(evt);
            }
        });

        labelCampoInicial.setLabelFor(comboCampoInicial);
        labelCampoInicial.setText(resourceMap.getString("labelCampoInicial.text")); // NOI18N
        labelCampoInicial.setName("labelCampoInicial"); // NOI18N
        labelCampoInicial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCampoInicialMouseClicked(evt);
            }
        });

        comboCampoInicial.setName("comboCampoInicial"); // NOI18N
        comboCampoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCampoInicialActionPerformed(evt);
            }
        });

        fieldAccion.setText(resourceMap.getString("textoPrevio.text")); // NOI18N
        fieldAccion.setName("textoPrevio"); // NOI18N

        labelCampoFinal.setLabelFor(comboCampoInicial);
        labelCampoFinal.setText(resourceMap.getString("labelCampoFinal.text")); // NOI18N
        labelCampoFinal.setName("labelCampoFinal"); // NOI18N

        comboCampoFinal.setName("comboCampoFinal"); // NOI18N
        comboCampoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCampoFinalActionPerformed(evt);
            }
        });

        labelCondFinal.setText(resourceMap.getString("labelEfecto.text")); // NOI18N
        labelCondFinal.setName("labelEfecto"); // NOI18N

        fieldEfecto.setName("textoPosterior"); // NOI18N

        comboListaCondicion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboListaCondicion.setName("comboListaCondicion"); // NOI18N
        comboListaCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboListaCondicionActionPerformed(evt);
            }
        });

        comboListaEfecto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboListaEfecto.setName("comboListaEfecto"); // NOI18N
        comboListaEfecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboListaEfectoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCondicionInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCampoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboListaCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(160, 160, 160)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCondFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCampoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCampoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldEfecto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboListaEfecto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(comboCampoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(labelSeleccionFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDescripcion))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSeleccionFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(519, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
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
                            .addComponent(fieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSeleccionFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCampoFinal)
                    .addComponent(labelCampoInicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCampoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCampoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCondFinal)
                    .addComponent(labelCondicionInicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldEfecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboListaEfecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboListaCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addGap(91, 91, 91))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Llena el combo que contiene todos los formularios existentes
     */
    private void llenarComboFormularios(){
        javax.swing.DefaultComboBoxModel modelo = new javax.swing.DefaultComboBoxModel();
        modelo = (DefaultComboBoxModel) comboSeleccionFormulario.getModel();
        formularioActual= new Formulario();
        Vector forms = new Vector();
        forms=formularioActual.getTodosLosFormulario();
        int id;
        String nombreForm;
        for(int i=0;i<forms.size(); i++){
            id=Integer.parseInt(forms.get(i).toString());
            i++;
            nombreForm=forms.get(i).toString();
            modelo.addElement(new MiDato(nombreForm, id));
        }
        comboSeleccionFormulario.setModel(modelo);
    }

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
    // TODO add your handling code here:
        //String nombreFormulario = ((MiDato)this.comboSeleccionFormulario.getSelectedItem()).nombre;
        //Se inicializan los campos del Comando
        int IDComandoAgregado=0;
        comandoActual.IDFormulario=((MiDato)this.comboSeleccionFormulario.getSelectedItem()).ID;
        comandoActual.IDFormularioTrabajar=comandoActual.IDFormulario;//este no sé para que es, en el script del profe no se usa
        comandoActual.descripcion=this.fieldDescripcion.getText();
        comandoActual.nombreComando=this.fieldNombre.getText();
        comandoActual.setTipoComando(this.comboTipo.getSelectedIndex() + 1);

        IDComandoAgregado=comandoActual.guardarComandoSinMascara();

        if(ConMascara==1){
            comandoActual.condicionInicial=fieldAccion.getText();
            comandoActual.estadoFinal=fieldEfecto.getText();
            comandoActual.tipoCampoInicial=((TipoCampo)comboCampoInicial.getSelectedItem()).nombre;
            comandoActual.tipoCampoFinal=((TipoCampo)comboCampoFinal.getSelectedItem()).nombre;
            comandoActual.IDComando=IDComandoAgregado;///Esto es lo unico que hace falta arreglar esto
            comandoActual.guardarComandoConMascara();
        }
        this.dispose();
    }//GEN-LAST:event_botonAceptarActionPerformed

    private int getIDFormulario(String nombreForm) {
        int ID = -1;
        ControladorBD contr = new ControladorBD();
        try {
            ResultSet resultado = contr.getResultSet("select correlativo from FORMULARIO where nombre = '" + nombreForm + "' ;");
            resultado.next();
            ID = Integer.parseInt(resultado.getObject("correlativo").toString());
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return ID;
    }

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed

    //if(ConMascara==0){
        if(!comboTipo.getSelectedItem().toString().equalsIgnoreCase("Comando con Máscara")){
        ocultarCamposConMascara();

        ConMascara=0;
    }
    else{
    aparecerCamposConMascara();
        ConMascara=1;
    }
    }//GEN-LAST:event_comboTipoActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed
    private void comboCampoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCampoInicialActionPerformed
        System.out.print(((TipoCampo)comboCampoInicial.getSelectedItem()).tipoDeTipoCampo);
        int tipoDeTipoCampo=((TipoCampo)comboCampoInicial.getSelectedItem()).tipoDeTipoCampo;
        //int correlativoTipoCampo=((TipoCampo)comboCampoInicial.getSelectedItem()).correlativo;
        int correlativoTipoCampo=555; //ya casi arregle esto, luisk
        Lista lista;
        if(frameManejoCampos.LISTA==tipoDeTipoCampo){
            lista=new Lista();


            javax.swing.DefaultComboBoxModel modelo = new javax.swing.DefaultComboBoxModel();
            //----------------------------------
            Vector miembrosLista;
        miembrosLista=lista.getMiembrosListaPorIDLista(correlativoTipoCampo);
        int id;
        String miembroLista;
        for(int i=0;i<miembrosLista.size(); i++){
            //id=Integer.parseInt(miembrosLista.get(i).toString());
           // i++;
            miembroLista=miembrosLista.get(i).toString();


            modelo.addElement(new MiDato(miembroLista, 0));

        }


            //-----------------------------------
            comboListaCondicion.setModel(modelo);
            comboListaCondicion.setVisible(true);
        }
        else{
            comboListaCondicion.setVisible(false);
        }
    }//GEN-LAST:event_comboCampoInicialActionPerformed

    private void comboSeleccionFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSeleccionFormularioActionPerformed
    System.out.print("asdfasdf"+"  "+((MiDato)comboSeleccionFormulario.getSelectedItem()).ID);        // TODO add your handling code here:

        javax.swing.DefaultComboBoxModel modelo = new javax.swing.DefaultComboBoxModel();
        modelo.removeAllElements();

        javax.swing.DefaultComboBoxModel modelo2 = new javax.swing.DefaultComboBoxModel();
        modelo2.removeAllElements();
        comandoActual = new Comando(); // Clase comando con la que trabajara la interfaz

        formularioActual= new Formulario();
        Vector forms = new Vector();
        forms=formularioActual.getMiembrosFormularioPorID(((MiDato)comboSeleccionFormulario.getSelectedItem()).ID);
        int id;
        String tipoCampo;
        int tipoDeTipoCampo;
        for(int i=0;i<forms.size(); i++){
            id=Integer.parseInt(forms.get(i).toString());
            i++;
            tipoCampo=forms.get(i).toString();
            i++;
            tipoDeTipoCampo=Integer.parseInt(forms.get(i).toString());
            modelo.addElement(new TipoCampo(tipoDeTipoCampo, tipoCampo, id));
            modelo2.addElement(new TipoCampo(tipoDeTipoCampo, tipoCampo, id));
        }

    comboCampoInicial.setModel(modelo);
    comboCampoFinal.setModel(modelo2);


    }//GEN-LAST:event_comboSeleccionFormularioActionPerformed

private void comboCampoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCampoFinalActionPerformed
        System.out.print(((TipoCampo)comboCampoInicial.getSelectedItem()).tipoDeTipoCampo);
        int tipoDeTipoCampo=((TipoCampo)comboCampoFinal.getSelectedItem()).tipoDeTipoCampo;
        //int correlativoTipoCampo=((TipoCampo)comboCampoInicial.getSelectedItem()).correlativo;
        int correlativoTipoCampo=555; //ya casi arregle esto, luisk
        Lista lista;
        if(frameManejoCampos.LISTA==tipoDeTipoCampo){
            lista=new Lista();


            javax.swing.DefaultComboBoxModel modelo = new javax.swing.DefaultComboBoxModel();
            //----------------------------------
            Vector miembrosLista;
        miembrosLista=lista.getMiembrosListaPorIDLista(correlativoTipoCampo);
        int id;
        String miembroLista;
        for(int i=0;i<miembrosLista.size(); i++){
            //id=Integer.parseInt(miembrosLista.get(i).toString());
           // i++;
            miembroLista=miembrosLista.get(i).toString();


            modelo.addElement(new MiDato(miembroLista, 0));

        }


            //-----------------------------------
            comboListaEfecto.setModel(modelo);
            comboListaEfecto.setVisible(true);
        }
        else{
            comboListaEfecto.setVisible(false);
        }
}//GEN-LAST:event_comboCampoFinalActionPerformed

private void ocultarCamposConMascara(){
    comboCampoInicial.setVisible(false);
    comboCampoFinal.setVisible(false);
    fieldAccion.setVisible(false);
    fieldEfecto.setVisible(false);
    labelCampoFinal.setVisible(false);
    labelCampoInicial.setVisible(false);
    labelCondicionInicial.setVisible(false);
    labelCondFinal.setVisible(false);
}
private void aparecerCamposConMascara(){
        comboCampoInicial.setVisible(true);
        comboCampoFinal.setVisible(true);
        fieldAccion.setVisible(true);
        fieldEfecto.setVisible(true);
        labelCampoFinal.setVisible(true);
         labelCampoInicial.setVisible(true);
    labelCondicionInicial.setVisible(true);
    labelCondFinal.setVisible(true);
}
private void labelCampoInicialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCampoInicialMouseClicked
    // TODO add your handling code here:
}//GEN-LAST:event_labelCampoInicialMouseClicked

private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
ocultarCamposConMascara();    // TODO add your handling code here:
}//GEN-LAST:event_formComponentShown

private void comboListaCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboListaCondicionActionPerformed
    // TODO add your handling code here:
    fieldAccion.setText(comboListaCondicion.getSelectedItem().toString().trim());
}//GEN-LAST:event_comboListaCondicionActionPerformed

private void comboListaEfectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboListaEfectoActionPerformed
    // TODO add your handling code here:
        fieldEfecto.setText(comboListaEfecto.getSelectedItem().toString().trim());
}//GEN-LAST:event_comboListaEfectoActionPerformed
    private void llenarCombosDificiles() {
        ControladorBD buscador = new ControladorBD();
        javax.swing.DefaultComboBoxModel modelo = new javax.swing.DefaultComboBoxModel();
        modelo = (DefaultComboBoxModel) comboCampoInicial.getModel();

        //HAGAN DOCUMENTACION PARA NO TENER QUE BATIAR Q PUTAS HACE CADA COSA Q AGREGAN! - ALBERTO
        try {

            ResultSet resultado = buscador.getResultSet("select nombre,IDTipoCampo from MIEMBROFORMULARIO WHERE IDFORMULARIO = ;" + IDForm);

            while (resultado.next()) {
                modelo.addElement(resultado.getObject(2).toString());
                correlativo.add(resultado.getObject(1));
            }

        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }

        comboSeleccionFormulario.setModel(modelo);
        comboSeleccionFormulario.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frameComandos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JComboBox comboCampoFinal;
    private javax.swing.JComboBox comboCampoInicial;
    private javax.swing.JComboBox comboListaCondicion;
    private javax.swing.JComboBox comboListaEfecto;
    private javax.swing.JComboBox comboSeleccionFormulario;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JTextField fieldAccion;
    private javax.swing.JTextField fieldDescripcion;
    private javax.swing.JTextField fieldEfecto;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JLabel labelCampoFinal;
    private javax.swing.JLabel labelCampoInicial;
    private javax.swing.JLabel labelCondFinal;
    private javax.swing.JLabel labelCondicionInicial;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSeleccionFormulario;
    private javax.swing.JLabel labelTipo;
    // End of variables declaration//GEN-END:variables
    private int IDForm;
    private Formulario datosFormulario;
}
