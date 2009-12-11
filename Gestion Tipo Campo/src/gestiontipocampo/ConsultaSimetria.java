/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestiontipocampo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Clase donde están todas las consultas a la base de datos con la información de las simetrías
 * @author lucachaco
 */
public class ConsultaSimetria extends ControladorBD{

    public ConsultaSimetria(){

    }

    public void agregarSimetria(int IDForm1,  int IDForm2,String elementosForm1, String elementosForm2,int IDCampoLlaveForm1,int IDCampoLlaveForm2){

        try { //Se busca el ID de los datos que acaba de insertar

            this.doUpdate("INSERT INTO SIMETRICOS (IDForm1,IDForm2,ElementosForm1,ElementosForm2,IDTipoCampoLlavePrimariaForm1,IDTipoCampoLlavePrimariaForm2) VALUES ("+
                    IDForm1+","+IDForm2+",'"+elementosForm1+"','"+elementosForm2+"',"+IDCampoLlaveForm1+","+IDCampoLlaveForm2+");");
            System.out.println("* agregada Relación Simetria: " +IDForm1+" - "+ IDForm2 );


        } catch (Exception e) {
            System.out.println("* Exception: *" + e.toString());
        }

    }

    public Vector obtenerTodasLasSimetrias() {

        Vector campos = new Vector();
        ResultSet result = null;

        //int tipoCampo;
        try {
            result = this.getResultSet("select IDForm1, IDForm2 from  SIMETRICAS;");
            while (result.next()) {
                campos.add(result.getObject("IDForm1").toString());
                campos.add(result.getObject("IDForm2").toString());
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
