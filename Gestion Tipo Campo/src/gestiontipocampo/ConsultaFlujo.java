/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontipocampo;

import java.sql.SQLException;
import java.util.Vector;

/// <summary>
/// Clase que contiene las consultas de la 3 capa de la clase flujo
/// </summary>
public class ConsultaFlujo extends ControladorBD {

    /// <summary>
    /// Constructor por defecto
    /// </summary>
    public ConsultaFlujo() {
    }

    /// <summary>
    /// Crea nuevo flujo en la BD y devuelve el correlativo del flujo recien creado.
    /// </summary>
    /// <param name="nombre"></param>
    /// <param name="descripcion"></param>
    /// <param name="correlativoRaiz"></param>
    /// <returns></returns>
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

    /// <summary>
    /// Actualiza una actividaden la base de datos
    /// </summary>
    /// <param name="consulta"></param>
    public void actualizarActividad(String consulta) {
        this.doUpdate(consulta);
    }

    /// <summary>
    /// Recupera los datos de un flujo ya creado y devuelve los datos en un vector
    /// </summary>
    /// <param name="correlativo"></param>
    /// <returns></returns>
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

    /// <summary>
    /// actualizar los datos de un flujo ya creado en la Base de Datos
    /// </summary>
    /// <param name="correlativo"></param>
    /// <param name="nombre"></param>
    /// <param name="descripcion"></param>
    /// <param name="raiz"></param>
    public void actualizar(int correlativo, String nombre, String descripcion, int raiz) {
        this.doUpdate("UPDATE FLUJO set nombre = '" + nombre + "', descripcion= '" + descripcion + "', actividadRaiz = '" + raiz + "' WHERE correlativo = " + correlativo + ";");
    }

    /// <summary>
    /// Metodo para borrar un flujo de trabajo de la base de datos
    /// </summary>
    /// <param name="correlativo"></param>
    public void borrarFlujo(int correlativo) {
        this.doUpdate("delete from FLUJO where correlativo = " + correlativo + ";");
    }


    /// <summary>
    /// Metodo para probar en la BD si ya existe un flujo con el nombre dado
    /// </summary>
    /// <param name="nombre"></param>
    /// <returns></returns>
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
