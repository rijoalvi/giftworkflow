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

    public int agregarMaestroDetalle(int IDFormularioMaestro, String nombreFormularioMaestro, int IDFormularioDetalle, String nombreFormularioDetalle, String detalleObligatorio){
        int id = -1;
        String[] incremental = new String[1];
        incremental[0] = "ID";
        try { //Se busca el ID de los datos que acaba de insertar

            resultado =this.doUpdate("INSERT INTO MAESTRODETALLE (IDFormularioMaestro,nombreFormularioMaestro,IDFormularioDetalle,nombreFormularioDetalle, detalleObligatorio) VALUES ("+IDFormularioMaestro+",'"+nombreFormularioMaestro+"',"+IDFormularioDetalle+",'"+nombreFormularioDetalle+"','"+detalleObligatorio+"' );", incremental);
            System.out.println("* agregado MaestroDetalle: " +nombreFormularioMaestro+" ."+nombreFormularioDetalle );
            while (resultado.next()) {
                id = resultado.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("* Exception: *" + e.toString());
        }
        return id;
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

    void agregarCamposEnRelacionMaestroDetalle(int IDMaestroDetalle, Vector vectorCamposDetalleSeleccionados, Vector vectorCamposMaestroSeleccionados) {
        /*int id = -1;
        String[] incremental = new String[1];
        incremental[0] = "ID";*/
        try { //Se busca el ID de los datos que acaba de insertar
            String consulta = "";

            TipoCampo dato;
            for(int i = 0; i < vectorCamposDetalleSeleccionados.size();i++){
                dato = (TipoCampo)vectorCamposDetalleSeleccionados.get(i);
                consulta += "INSERT INTO CAMPOSDETALLE (IDMaestroDetalle, IDCampo, nombreCampo) VALUES ("+IDMaestroDetalle+
                            ","+dato.correlativo+",'"+dato.nombre+"');"+'\n';
            }

            for(int i = 0; i < vectorCamposMaestroSeleccionados.size();i++){
                dato = (TipoCampo)vectorCamposMaestroSeleccionados.get(i);
                consulta += "INSERT INTO CAMPOSMAESTRO (IDMaestroDetalle, IDCampo, nombreCampo) VALUES ("+IDMaestroDetalle+
                            ","+dato.correlativo+",'"+dato.nombre+"');"+'\n';
            }
            this.doUpdate(consulta);
            /*System.out.println("* agregado MaestroDetalle: " +nombreFormularioMaestro+" ."+nombreFormularioDetalle );
            while (resultado.next()) {
                id = resultado.getInt(1);
            }*/
        } catch (Exception e) {
            System.out.println("* Exception: *" + e.toString());
        }
        //return id;
    }

    int IDDetalleDelMaestro(int IDFormulario) {
        int correlativo = -1;
        ResultSet result = null;
        try {
            result = this.getResultSet("select IDFormularioDetalle from MAESTRODETALLE where IDFormularioMaestro = " + IDFormulario + ";");
            //hijas = new int[resultado.getFetchSize()];
            while (result.next()) {
                correlativo = result.getInt("IDFormularioDetalle");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return correlativo;
    }

    int IDMaestroDelDetalle(int IDFormulario) {
        int correlativo = -1;
        ResultSet result = null;
        try {
            result = this.getResultSet("select IDFormularioMaestro from MAESTRODETALLE where IDFormularioDetalle = " + IDFormulario + ";");
            //hijas = new int[resultado.getFetchSize()];
            while (result.next()) {
                correlativo = result.getInt("IDFormularioMaestro");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return correlativo;
    }

}
