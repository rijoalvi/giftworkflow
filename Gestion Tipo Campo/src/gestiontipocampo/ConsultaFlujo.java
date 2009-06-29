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
 * @author admin
 */
public abstract class ConsultaFlujo extends ControladorBD {

    public ConsultaFlujo() {
    }

    /**
     * Crea nuevo flujo en la BD y devuelve el correlativo del flujo recien creado.
     * @param nombre
     * @param descripcion
     * @param correlativoRaiz - correlativo de la actividad en la raiz del flujo
     * @return correlativo del flujo recien creado.
     */
    public int nuevoFlujo(String nombre, String descripcion, int correlativoRaiz) {
        int correlativo = -1;
        String[] incremental = {"correlativo"};
        ResultSet resultado = null;
        try {
            resultado = this.doUpdate("insert into FLUJO (nombre, descripcion, actividadRaiz) values ('" + nombre + "', '" + descripcion + "', " + correlativoRaiz + ";", incremental);
            while (resultado.next()) {
                correlativo = resultado.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return correlativo;
    }

    /**
     * Metodo que recupera datos de un flujo ya creado y devuelve los datos en un vector
     * @param correlativo
     * @return //Los datos tienen que ir en el siguiente orden: nombre, descripcion, raiz
     */
    public Vector<String> getFlujo(int correlativo) {
        Vector<String> retorno = new Vector<String>();
        ResultSet resultado = null;
        try {
            resultado = this.getResultSet("select nombre, descripcion, actividadRaiz from FLUJO where correlativo = " + correlativo + ";");
            while (resultado.next()) {
                retorno.add(resultado.getString("nombre"));
                retorno.add(resultado.getString("descripcion"));
                retorno.add(resultado.getString("actividadRaiz"));
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return retorno;
    }

    /**
     * Matodo para actualizar los datos de un flujo ya creado en la BD
     * @param correlativo
     * @param nombre
     * @param descripcion
     * @param raiz
     */
    public void actualizar(int correlativo, String nombre, String descripcion, int raiz) {
        this.doUpdate("UPDATE FLUJO set nombre = '" + nombre + "', descripcion= '" + descripcion + "', actividadRaiz = '" + raiz + "' WHERE correlativo = " + correlativo + ";");
    }
}
