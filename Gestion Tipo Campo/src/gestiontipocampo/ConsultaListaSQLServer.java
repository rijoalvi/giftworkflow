/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
package gestiontipocampo;

import java.util.*;

/// <summary>
/// Clase que contiene las consultas de la tercera capa para la implementación SQL Server de la clase Lista
/// </summary>
public class ConsultaListaSQLServer extends ConsultaLista {

    /// <summary>
    /// Agrega un elemento a la lista seleccionada
    /// </summary>
    /// <param name="nombreMiembro"></param>
    /// <param name="posicion"></param>
    /// <param name="correlativo"></param>
    @Override
    public void agregarMiembro(String nombreMiembro, int posicion, int correlativo) {//agregar elemento a la lista
        System.out.print("agregando...");
        this.doUpdate("insert into MIEMBROLISTA (valor,IDLista, numeroElemento) values ('" + nombreMiembro + "'," + correlativo + ", " + posicion + ");");
    }

    /// <summary>
    /// retorna la información de lista seleccionada
    /// </summary>
    /// <param name="nombreMiembro"></param>
    /// <param name="correlativo"></param>
    /// <returns></returns>
    @Override
    public Map<String, String> getInfoLista(int correlativo) {
        Vector campos = new Vector();
        campos.add("correlativo");//diferencia con mysql
        campos.add("nombre");
        campos.add("descripcion");
        campos.add("ultimaActualizacion");
        campos.add("IDMiembroPorDefecto");
        campos.add("conOrden");
        campos.add("valor");//diferencia con mysql
        return this.getResultSetMap("select t.correlativo, nombre, descripcion, ultimaActualizacion, IDMiembroPorDefecto, conOrden, m.valor from TIPOCAMPO t, LISTA l,MIEMBROLISTA m where t.correlativo=" + correlativo + " AND l.correlativo=t.correlativo  and m.correlativo=l.IDMiembroPorDefecto;", campos);

    }
}
