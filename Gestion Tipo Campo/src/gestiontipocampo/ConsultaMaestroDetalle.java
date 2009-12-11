/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *

package gestiontipocampo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author luiscarlosch@gmail.com
 */
public class ConsultaMaestroDetalle extends ControladorBD{

    /**
     * Constructor por defecto
     */
    public ConsultaMaestroDetalle(){

    }

    /**
     * Agrega una nueva relación de tipo Maestro Detalle en la base de datos
     * @param IDFormularioMaestro
     * @param nombreFormularioMaestro
     * @param IDFormularioDetalle
     * @param nombreFormularioDetalle
     * @param detalleObligatorio
     * @return int correlativo que identifica la relación maestro-detalle recien ingresada en la base de datos
     */
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

    /**
     * Obtiene todas las relaciones de tipo maestro detalle que se encuentran en la base de datos de configuración
     * @return Vector con el nombre del maestro en indices pares y el del detalle en los indices impares.
     */
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


    /**
     * Método que obtiene las actividades hijas de la actividad compuesta identificada por el parámetro enviado
     * @param correlativo de la actividad compuesta de la que se desean obtener las actividades hijas
     * @return int[] vector con los indices de las actividades miembro que conforman la actividad copuesta
     */
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

    /**
     * Método que agrega campos que serán visibles en las relaciones Maestro-Detalle
     * @param int IDMaestroDetalle al que se le desean agregar los campos
     * @param Vector de tipoCampo vectorCamposDetalleSeleccionados
     * @param Vector de tipoCampo vectorCamposMaestroSeleccionados
     */

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


    /**
     * Método que recupera el id del formulario detalle al que hace referencia el formulario Maestro dueño del id enviado por parámetro
     * @param IDFormulario del maestro del detalle buscado
     * @return int id del Formulario Detalle del formulario indicado por parámetro
     */
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

    /**
     * Método que recupera el id del formulario Maestro del formulario indicado por el parámetro
     * @param int IDFormulario detalle del que se quiere conocer el maestro
     * @return int IDFormulario Maestro del formulario indicado en el parámetro
     */
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
