/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontipocampo;

import java.sql.ResultSet;

/// <summary>
/// Clase que contiene las consultas para la implementación SQL Server
/// </summary>
public class consultasSQL {

    protected ControladorBD control;

    /// <summary>
    /// retorna todos los elementos de la base de datos para la tabla TipoCampo
    /// </summary>
    /// <param name="columnaAComparar"></param>
    /// <param name="elemComparacion"></param>
    /// <returns></returns>
    ResultSet seleccionarTodoTipoCampo(String columnaAComparar, String elemComparacion) {
        control = new ControladorBD();
        ResultSet respuesta = null;
        respuesta = control.getResultSet("Select * from TIPOCAMPO where " + columnaAComparar + " = " + elemComparacion);
        return respuesta;
    }

    /// <summary>
    /// retorna todos los elementos de la base de datos para una tabla señalada por el usuario
    /// </summary>
    /// <param name="tipo"></param>
    /// <param name="columnaAComparar"></param>
    /// <param name="elemComparacion"></param>
    /// <returns></returns>
    ResultSet seleccionarTodoGenerico(String tipo, String columnaAComparar, String elemComparacion) {
        control = new ControladorBD();
        ResultSet respuesta = null;
        respuesta = control.getResultSet("Select * from " + tipo + " where " + columnaAComparar + " = " + elemComparacion);
        return respuesta;
    }
}
