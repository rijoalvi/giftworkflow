/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontipocampo;

import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class ConsultaFlujo extends ControladorBD {

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
        String[] incremental = new String[1];
        incremental[0] = "correlativo";
        try {
            resultado = this.doUpdate("insert into FLUJO (nombre, descripcion, actividadRaiz) values ('" + nombre + "', '" + descripcion + "', " + correlativoRaiz + ");", incremental);
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
     * Metodo para actualizar los datos de un flujo ya creado en la BD
     * @param correlativo
     * @param nombre
     * @param descripcion
     * @param raiz
     */
    public void actualizar(int correlativo, String nombre, String descripcion, int raiz) {
        this.doUpdate("UPDATE FLUJO set nombre = '" + nombre + "', descripcion= '" + descripcion + "', actividadRaiz = '" + raiz + "' WHERE correlativo = " + correlativo + ";");
    }

    /**
     * Metodo para borrar flujo
     * @param correlativo - correlativo del flujo a borrar
     */
    public void borrarFlujo(int correlativo) {
        this.doUpdate("delete from FLUJO where correlativo = " + correlativo + ";");
    }

    /**
     * Metodo para probar en la BD si ya existe un flujo con el nombre dado
     * @param nombre - nombre de flujo a probar
     * @return true - ya existe, false - no existe
     */
    public boolean yaExiste(String nombre) {
        boolean retorno = false;
        try {
            resultado = this.getResultSet("select correlativo from FLUJO where nombre = '" + nombre + "';");
            if (resultado.next()) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return retorno;
    }
}
