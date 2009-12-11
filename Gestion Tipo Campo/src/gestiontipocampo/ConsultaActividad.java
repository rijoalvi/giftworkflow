/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
package gestiontipocampo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/// <summary>
/// Clase que se encarga de realizar las consultas para el formulario actividad
/// </summary>
public abstract class ConsultaActividad extends ControladorBD {

    /// <summary>
    /// Constructor por omisión
    /// </summary>
    public ConsultaActividad() {
    }

    /// <summary>
    /// Crea nueva Actividad en la base de datos y devuelve el correlativo de la Actividad recien creada.
    /// </summary>
    /// <param name="correlativoFlujo"></param>
    /// <param name="nombre"></param>
    /// <param name="descripcion"></param>
    /// <param name="tipo"></param>
    /// <param name="estadoInicial"></param>
    /// <param name="estadoFinal"></param>
    /// <param name="simple"></param>
    /// <param name="repetible"></param>
    /// <param name="masiva"></param>
    /// <param name="requiereRevision"></param>
    /// <param name="hitoDeControl"></param>
    /// <returns></returns>
    public abstract int nuevaActividad(int correlativoFlujo, String nombre, String descripcion, int tipo, String estadoInicial, String estadoFinal, boolean simple, boolean repetible, boolean masiva, boolean requiereRevision, boolean hitoDeControl, boolean paralelo, boolean exclusivo, boolean obligatorio);

    /// <summary>
    /// Actualiza los datos de la Actividad existente en la base de datos.
    /// </summary>
    /// <param name="correlativo"></param>
    /// <param name="correlativoFlujo"></param>
    /// <param name="nombre"></param>
    /// <param name="descripcion"></param>
    /// <param name="tipo"></param>
    /// <param name="estadoInicial"></param>
    /// <param name="estadoFinal"></param>
    /// <param name="simple"></param>
    /// <param name="repetible"></param>
    /// <param name="masiva"></param>
    /// <param name="requiereRevision"></param>
    /// <param name="hitoDeControl"></param>
    public abstract void actualizarActividad(int correlativo, int correlativoFlujo, String nombre, String descripcion, int tipo, String estadoInicial, String estadoFinal, boolean simple, boolean repetible, boolean masiva, boolean requiereRevision, boolean hitoDeControl, boolean paralelo, boolean exclusivo, boolean obligatorio);

    /// <summary>
    /// Devuelve los datos de la actividad segun el correlativo
    /// </summary>
    /// <param name="correlativo"></param>
    /// <returns></returns>
    public abstract String[] getActividad(int correlativo);

    /// <summary>
    /// Devuelve todas las actividades que esten creadas en la Base de Datos
    /// </summary>
    /// <returns></returns>
    public abstract Vector obtenerTodasLasActividades();

    /// <summary>
    /// Elimina la actividad de la base de datos.
    /// </summary>
    /// <param name="correlativo"></param>
    /// <returns></returns>
    public abstract int eliminar(int correlativo);

    /// <summary>
    /// Agrega comando a la base de datos como parte de la Actividad (se supone que esta actividad es simple). Si ya existe un comando en esta posicion (orden) se corre una posicion adelante (Tambien todos los comandos con la posicion posterior).
    /// </summary>
    /// <param name="correlativoActividad"></param>
    /// <param name="IDComando"></param>
    /// <param name="orden"></param>
    /// <param name="esObligatorio"></param>
    public abstract void agregarComando(int correlativoActividad, int IDComando, int orden, boolean esObligatorio);

    /// <summary>
    /// Desvincula comando de la actividad (se supone que actividad es simple). Hay que correr otros comandos para conservar el orden
    /// </summary>
    /// <param name="correlativo"></param>
    /// <param name="IDComando"></param>
    public abstract void desvincularComando(int correlativo, int IDComando);

    /// <summary>
    /// Desvincula dos actividades
    /// </summary>
    /// <param name="correlativoMadre"></param>
    /// <param name="correlativoHija"></param>
    public abstract void desvincularActividad(int correlativoMadre, int correlativoHija);

    /// <summary>
    /// Desvincula dos actividades
    /// </summary>
    /// <param name="correlativoMadre"></param>
    /// <param name="correlativoHija"></param>
    /// <param name="orden"></param>
    /// <param name="esObligatorio"></param>
    public abstract void vincularActividad(int correlativoMadre, int correlativoHija, int orden, boolean esObligatorio);

    /// <summary>
    /// Devuelve los correlativos de las hijas de cierta actividad madre
    /// </summary>
    /// <param name="correlativo"></param>
    /// <returns></returns>
    public int[] getHijasActividades(int correlativo) {
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

    /// <summary>
    /// Devuelve los correlativos de los comandos de las hijas de cierta actividad madre
    /// </summary>
    /// <param name="correlativo"></param>
    /// <returns></returns>
    public int[] getHijosComandos(int correlativo) {
        int[] hijos = null;
        int i = 0;
        ResultSet resultado = null;
        try {
            resultado = this.getResultSet("select correlativoComando from MIEMBROACIVIDADSIMPLE where correlativoMadre = " + correlativo + ";");
            hijos = new int[resultado.getFetchSize()];
            while (resultado.next()) {
                hijos[i] = resultado.getInt("correlativoComando");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return hijos;
    }
}
