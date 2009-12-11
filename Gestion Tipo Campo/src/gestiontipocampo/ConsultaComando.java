/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontipocampo;

import java.sql.*;
import java.util.Vector;

/// <summary>
/// Clase que contiene las consultas de la 3 capa de la clase comando
/// </summary>
public abstract class ConsultaComando extends ControladorBD {

    /// <summary>
    /// Agrega una tupla a la BD en la tabla COMANDO
    /// </summary>
    /// <param name="CorrelativoFormulario"></param>
    /// <param name="NombreComando"></param>
    /// <param name="DescripcionComando"></param>
    /// <param name="tipoComando"></param>
    /// <param name="correlativoFormularioATrabajar"></param>
    /// <param name="fechaActualizacion"></param>
    public abstract int agregarComando(int CorrelativoFormulario, String NombreComando, String DescripcionComando, int tipoComando, int correlativoFormularioATrabajar, String fechaActualizacion);

    /// <summary>
    /// Agrega una accion para el comando con mascara
    /// </summary>
    /// <param name="IDComando"></param>
    /// <param name="TipoCampoInicial"></param>
    /// <param name="CondicionInicial"></param>
    /// <param name="TipoCampoFinal"></param>
    /// <param name="EstadoFinal"></param>
    public void agregarComandoConMascara(int IDComando, String TipoCampoInicial, String CondicionInicial, String TipoCampoFinal, String EstadoFinal) {
        //INSERT INTO ComandoMascara (IDComando,TipoCampoInicial,CondicionInicial,TipoCampoFinal,EstadoFinal) VALUES (1,'tipoCampoInicial','condicion inicial','campoFinal','dsfa');
        this.doUpdate("INSERT INTO COMANDOMASCARA (IDComando,TipoCampoInicial,CondicionInicial,TipoCampoFinal,EstadoFinal) VALUES (" + IDComando + ",'" + TipoCampoInicial + "','" + CondicionInicial + "','" + TipoCampoFinal + "','" + EstadoFinal + "');");
    }

    /// <summary>
    /// Agrega un comando con máscara a la base de datos, y retorna el correlativo del comando
    /// </summary>
    /// <param name="IDComando"></param>
    /// <param name="TipoCampoInicial"></param>
    /// <param name="CondicionInicial"></param>
    /// <param name="TipoCampoFinal"></param>
    /// <param name="EstadoFinal"></param>
    /// <returns></returns>
    public int agregarComandoConMascaraYObtenerID(int IDComando, String TipoCampoInicial, String CondicionInicial, String TipoCampoFinal, String EstadoFinal) {
        //INSERT INTO ComandoMascara (IDComando,TipoCampoInicial,CondicionInicial,TipoCampoFinal,EstadoFinal) VALUES (1,'tipoCampoInicial','condicion inicial','campoFinal','dsfa');
        this.doUpdate("INSERT INTO  COMANDOMASCARA (IDComando,TipoCampoInicial,CondicionInicial,TipoCampoFinal,EstadoFinal) VALUES (" + IDComando + ",'" + TipoCampoInicial + "','" + CondicionInicial + "','" + TipoCampoFinal + "','" + EstadoFinal + "');");
        return 0;
    }

    /// <summary>
    /// Retorna todos los comandos en un vector como para cargarlos en un combo
    /// </summary>
    /// <returns></returns>
    public Vector obtenerTodosLosComandos() {
        Vector campos = new Vector();
        ResultSet resultado = null;
        //int tipoCampo;
        try {
            resultado = this.getResultSet("select ID, Nombre from COMANDO;");
            while (resultado.next()) {
                campos.add(resultado.getObject("ID").toString());
                campos.add(resultado.getObject("Nombre").toString());
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return campos;
    }

    /// <summary>
    /// Retorna todos los comandos de un formulario en un vector
    /// </summary>
    /// <param name="idForm"></param>
    /// <returns></returns>
    public Vector obtenerComandosFormulario(int idForm) {
        Vector campos = new Vector();
        ResultSet resultado = null;
        //int tipoCampo;
        try {
            resultado = this.getResultSet("select ID, Nombre from COMANDO where IDFormulario = '" + idForm + "';");
            while (resultado.next()) {
                campos.add(resultado.getObject("ID").toString());
                campos.add(resultado.getObject("Nombre").toString());
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return campos;
    }

    /// <summary>
    /// Retorna todos los datos de un comando según su correlativo
    /// </summary>
    /// <param name="correlativo"></param>
    /// <returns></returns>
    public String[] getComando(int correlativo) {
        String[] comando = new String[7];
        try {
            ResultSet resultado = this.getResultSet("select ID, IDFormulario, Nombre, Descripcion, Tipo, IDFormularioATrabajar, FechaActualizacion from COMANDO where ID = " + correlativo + ";");
            if (resultado.next()) {
                comando[0] = resultado.getString("ID");
                comando[1] = resultado.getString("IDFormulario");
                comando[2] = resultado.getString("Nombre");
                comando[3] = resultado.getString("Descripcion");
                comando[4] = resultado.getString("Tipo");
                comando[5] = resultado.getString("IDFormularioATrabajar");
                comando[6] = resultado.getString("FechaActualizacion");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return comando;
    }
}
