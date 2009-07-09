/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestiontipocampo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author luiscarlosch@gmail.com
 */
public class ConsultaMaestroDetalle extends ControladorBD{

    public ConsultaMaestroDetalle(){

    }

    public void agregarMaestroDetalle(int IDFormularioMaestro, String nombreFormularioMaestro, int IDFormularioDetalle, String nombreFormularioDetalle){

        try { //Se busca el ID de los datos que acaba de insertar

            this.doUpdate("INSERT INTO MAESTRODETALLE (IDFormularioMaestro,nombreFormularioMaestro,IDFormularioDetalle,nombreFormularioDetalle) VALUES ("+IDFormularioMaestro+",'"+nombreFormularioMaestro+"',"+IDFormularioDetalle+",'"+nombreFormularioDetalle+"');");
            System.out.println("* agregado MaestroDetalle: " +nombreFormularioMaestro+" ."+nombreFormularioDetalle );


        } catch (Exception e) {
            System.out.println("* Exception: *" + e.toString());
        }

    }

    public Vector obtenerTodosLosMaestroDetalle() {

        Vector campos = new Vector();
        ResultSet resultado = null;

        //int tipoCampo;
        try {
            resultado = this.getResultSet("select nombreFormularioMaestro, nombreFormularioDetalle from  MAESTRODETALLE;");
            while (resultado.next()) {
                campos.add(resultado.getObject("nombreFormularioMaestro").toString());
                campos.add(resultado.getObject("nombreFormularioDetalle").toString());
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return campos;
    }



    //public abstract void vincularActividad(int correlativoMadre, int correlativoHija, int orden, boolean esObligatorio);


    public int[] getHijasActividades(int correlativo){
        int[] hijas = null;
        int i = 0;
        ResultSet resultado = null;
        try {
            resultado = this.getResultSet("select correlativoHija from MIEMBROACIVIDADCOMPUESTA where correlativoMadre = " + correlativo + ";");
            hijas = new int[resultado.getFetchSize()];
            while (resultado.next()) {
                hijas[i] = resultado.getInt("correlativoHija");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return hijas;
    }



}
