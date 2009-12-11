/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frameConexiones.java
 *
 * Created on 21/03/2009, 04:48:00 PM
 *
package gestiontipocampo;

/**
 *
 * @author Administrator
 */
public class frameConexiones extends javax.swing.JFrame {

    /// <summary>
    /// Constructor por defecto
    /// </summary>
    public frameConexiones() {
        initComponents();
        grupo.add(MySqlEEUU);
        grupo.add(SQLServerECCI);
        grupo.add(SQLServerEEUU);
    }

    /// <summary>
    /// Constructor de la clase recibe un frame como madre
    /// </summary>
    public frameConexiones(GestionTipoCampoView mama) {
        this.madre = mama;
        initComponents();
        grupo.add(MySqlEEUU);
        grupo.add(SQLServerECCI);
        grupo.add(SQLServerEEUU);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        MySqlEEUU = new javax.swing.JRadioButton();
        SQLServerECCI = new javax.swing.JRadioButton();
        btnEstablecerConexion = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SQLServerEEUU = new javax.swing.JRadioButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gestiontipocampo.GestionTipoCampoApp.class).getContext().getResourceMap(frameConexiones.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        MySqlEEUU.setText(resourceMap.getString("opt1.text")); // NOI18N
        MySqlEEUU.setName("opt1"); // NOI18N
        MySqlEEUU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MySqlEEUUMouseClicked(evt);
            }
        });
        MySqlEEUU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MySqlEEUUActionPerformed(evt);
            }
        });

        SQLServerECCI.setText(resourceMap.getString("opt2.text")); // NOI18N
        SQLServerECCI.setName("opt2"); // NOI18N
        SQLServerECCI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SQLServerECCIMouseClicked(evt);
            }
        });

        btnEstablecerConexion.setText(resourceMap.getString("btnEstablecerConexion.text")); // NOI18N
        btnEstablecerConexion.setName("btnEstablecerConexion"); // NOI18N
        btnEstablecerConexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstablecerConexionMouseClicked(evt);
            }
        });

        btnRefrescar.setText(resourceMap.getString("btnRefrescar.text")); // NOI18N
        btnRefrescar.setName("btnRefrescar"); // NOI18N
        btnRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefrescarMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        SQLServerEEUU.setText(resourceMap.getString("SQLServerEEUU.text")); // NOI18N
        SQLServerEEUU.setName("SQLServerEEUU"); // NOI18N
        SQLServerEEUU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SQLServerEEUUMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btnRefrescar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEstablecerConexion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(MySqlEEUU)
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SQLServerEEUU)
                            .addComponent(SQLServerECCI))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MySqlEEUU)
                    .addComponent(SQLServerECCI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SQLServerEEUU)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEstablecerConexion)
                    .addComponent(btnRefrescar))
                .addGap(40, 40, 40))
        );

        MySqlEEUU.getAccessibleContext().setAccessibleName(resourceMap.getString("opt1.AccessibleContext.accessibleName")); // NOI18N
        SQLServerECCI.getAccessibleContext().setAccessibleName(resourceMap.getString("opt2.AccessibleContext.accessibleName")); // NOI18N
        SQLServerEEUU.getAccessibleContext().setAccessibleName(resourceMap.getString("jRadioButton3.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        probarConexiones();
    }//GEN-LAST:event_formComponentShown
    private void probarConexiones() {

        //btnEstablecerConexion.setEnabled(false);
        ControladorBD probadorConexiones = new ControladorBD();

        //ATENCION: YA NO HAY QUE COMENTAR NADA AQUÍ*********************************
        System.out.println("Conexiones no probadas, decida ud cual podría estar disponible");
        /*if (1 == probadorConexiones.probarConexion(2)) {
        jRadioButton2.setText("Disponible");
        jRadioButton2.setEnabled(true);

        jRadioButton1.setText("No disponible");
        jRadioButton1.setSelected(false);
        jRadioButton1.setEnabled(false);
        } else {
        System.out.println("Probando 1");
        jRadioButton2.setText("No disponible");
        jRadioButton2.setSelected(false);
        jRadioButton2.setEnabled(false);

        if (1 == probadorConexiones.probarConexion(1)) {
        jRadioButton1.setEnabled(true);
        jRadioButton1.setText("Disponible");
        //  jRadioButton1.setBackground(Color.green);
        }
        }*/

        jLabel1.setText("Por favor elija la Base de Datos a la que desea conectarse.");

    }
    private void MySqlEEUUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MySqlEEUUMouseClicked
        // TODO add your handling code here:
        if (true == MySqlEEUU.isSelected()) {
            btnEstablecerConexion.setEnabled(true);
            SQLServerECCI.setSelected(false);
        }
        if (false == MySqlEEUU.isSelected() && false == SQLServerECCI.isSelected()) {
            btnEstablecerConexion.setEnabled(false);
        }
        /*  else{
        btnEstablecerConexion.setEnabled(false);
        }*/
    }//GEN-LAST:event_MySqlEEUUMouseClicked

    private void MySqlEEUUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MySqlEEUUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MySqlEEUUActionPerformed

    private void btnEstablecerConexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstablecerConexionMouseClicked
        // TODO add your handling code here:
        if (MySqlEEUU.isSelected()) {
            ControladorBD.conexionSeleccionada = 1;
        } else {
            if (this.SQLServerECCI.isSelected()) {
                ControladorBD.conexionSeleccionada = 2;
            } else {
                ControladorBD.conexionSeleccionada = 3;
            }
        }
        if (madre != null) {
            madre.llenarTreeView();
        }
        this.dispose();
    }//GEN-LAST:event_btnEstablecerConexionMouseClicked

    private void SQLServerECCIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SQLServerECCIMouseClicked
        if (true == SQLServerECCI.isSelected()) {
            btnEstablecerConexion.setEnabled(true);
            MySqlEEUU.setSelected(false);
        }
        if (false == MySqlEEUU.isSelected() && false == SQLServerECCI.isSelected()) {
            btnEstablecerConexion.setEnabled(false);
        }
    }//GEN-LAST:event_SQLServerECCIMouseClicked

    private void btnRefrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefrescarMouseClicked

        btnRefrescar.setEnabled(false);
        btnEstablecerConexion.setEnabled(false);
        MySqlEEUU.setText("Revisando...");
        MySqlEEUU.setSelected(false);
        MySqlEEUU.setEnabled(false);
        SQLServerECCI.setText("Revisando...");
        SQLServerECCI.setSelected(false);
        SQLServerECCI.setEnabled(false);
        jLabel1.setVisible(true);
        jLabel1.setText("Por favor espere un momento.\n Se está revisando la conexión a las Bases de Datos.");
        probarConexiones();
        btnRefrescar.setEnabled(true);


}//GEN-LAST:event_btnRefrescarMouseClicked

    private void SQLServerEEUUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SQLServerEEUUMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_SQLServerEEUUMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frameConexiones().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton MySqlEEUU;
    private javax.swing.JRadioButton SQLServerECCI;
    private javax.swing.JRadioButton SQLServerEEUU;
    private javax.swing.JButton btnEstablecerConexion;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    private GestionTipoCampoView madre = null;
}
