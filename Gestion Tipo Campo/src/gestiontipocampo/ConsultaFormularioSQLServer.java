/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
package gestiontipocampo;

import java.sql.*;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Alberto
 */
/// <summary>
/// Clase que contiene las consultas de la implementación SQL Server de la tercera capa de la clase formulario
/// </summary>
public class ConsultaFormularioSQLServer extends ConsultaFormulario {

    /// <summary>
    /// Guarda un nuevo formulario en la BD
    /// </summary>
    /// <param name="nombre"></param>
    /// <param name="descripcion"></param>
    /// <returns></returns>
    public int guardaFormulario(String nombre, String descripcion) {
        int ID = -1;
        //Guarda en FORMULARIO
        this.doUpdate("Insert Into FORMULARIO (nombre, descripcion, ultimaActualizacion) VALUES ('" + nombre + "', '" + descripcion + "', GetDate())");
        try { //Se busca el ID de los datos que acaba de insertar
            ResultSet resultado = this.getResultSet("select correlativo from FORMULARIO where nombre = '" + nombre + "'");
            if (resultado.next()) {
                ID = resultado.getInt("correlativo");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }

        return ID;
    }

    /// <summary>
    /// Borra un miembro formulario en la BD
    /// </summary>
    /// <param name="ID"></param>
    public void borrarMiembro(int ID) {
        this.doUpdate("delete from MIEMBROFORMULARIO where correlativo = " + ID + ";");
    }

    /// <summary>
    /// Modifica los datos del miembroFormulario indicado en el ID
    /// </summary>
    /// <param name="ID"></param>
    /// <param name="nombre"></param>
    /// <param name="valX"></param>
    /// <param name="valY"></param>
    /// <param name="tipoLetra"></param>
    /// <param name="color"></param>
    /// <param name="tamanoLetra"></param>
    /// <param name="IDTP"></param>
    public void updateMiembro(int ID, String nombre, int valX, int valY, int ancho, int alto, String tipoLetra, int color, int tamanoLetra, int IDTP, int tabIndex, String estiloLetra) {
        this.doUpdate("UPDATE MIEMBROFORMULARIO set nombre = '" + nombre + "', valX = " + valX + ", valY = " + valY + ", ancho = " + ancho + ", alto = " + alto + ", tipoLetra = '" + tipoLetra + "', color = " + color + ", tamanoLetra = " + tamanoLetra + ", IDTipoCampo = " + IDTP + ", tabIndex = " + tabIndex + ", estiloLetra = '" + estiloLetra + "' WHERE correlativo = " + ID + ";");
    }

    /// <summary>
    /// Actualiza la posicion del componente dentro del formulario
    /// </summary>
    /// <param name="ID"></param>
    /// <param name="valX"></param>
    /// <param name="valY"></param>
    public void updatePosicion(int ID, int valX, int valY) {
        this.doUpdate("UPDATE MIEMBROFORMULARIO set valX = " + valX + ", valY = " + valY + " WHERE correlativo = " + ID + ";");
    }

    /// <summary>
    /// Actualiza el tab index
    /// </summary>
    /// <param name="ID"></param>
    /// <param name="tab"></param>
    public void updateTabIndex(int ID, int tab) {
        this.doUpdate("UPDATE MIEMBROFORMULARIO set tabIndex = " + tab + " WHERE correlativo = " + ID + ";");
    }

    /// <summary>
    /// Modifica el nombre del formulario indicado mediante el ID
    /// </summary>
    /// <param name="ID"></param>
    public void modificarNombre(String nombre, int ID) {
        this.doUpdate("UPDATE MIEMBROFORMULARIO set nombre = '" + nombre + " WHERE correlativo = " + ID + ";");
    }

    /// <summary>
    /// Modifica la descripcion del formulario
    /// </summary>
    /// <param name="descp"></param>
    /// <param name="ID"></param>
    public void modificarDescripcion(String descp, int ID) {
        this.doUpdate("UPDATE MIEMBROFORMULARIO set descripcion = '" + descp + " WHERE correlativo = " + ID + ";");
    }

    /// <summary>
    /// Obtiene los datos del formulario indicado en el correlativo
    /// </summary>
    /// <param name="correlativo"></param>
    /// <returns></returns>
    public Vector obtenerDatosFormulario(int correlativo) {
        String consulta = "Select nombre, descripcion, ultimaActualizacion From FORMULARIO Where correlativo = " + correlativo;
        Vector campos = new Vector();
        campos.add("nombre");
        campos.add("descripcion");
        campos.add("ultimaActualizacion");
        Map<String, String> mapaDatos = this.getResultSetMap(consulta, campos);
        campos.clear();
        campos.add(mapaDatos.get("nombre"));
        campos.add(mapaDatos.get("descripcion"));
        campos.add(mapaDatos.get("ultimaActualizacion"));
        return campos;
    }

    /// <summary>
    /// Obtiene todos los miembros del formulario y los retorna dentro de un vector
    /// </summary>
    /// <param name="correlativoFormulario"></param>
    /// <returns></returns>
    public Vector obtenerMiembros(int correlativoFormulario) {
        Vector miembros = new Vector();
        //ID, this.correlativo, nombre, valX, valY, tipoLetra, color, tamanoLetra, IDTP
        String consulta = "Select correlativo, nombre, valX, valY, ancho, alto, tipoLetra, color, tamanoLetra, IDTipoCampo, IDCampo, tabIndex, estiloLetra From MIEMBROFORMULARIO Where IDFormulario = " + correlativoFormulario;
        ResultSet resultado = this.getResultSet(consulta);


        try {
            while (resultado.next()) {
                miembros.add(resultado.getObject("correlativo"));
                miembros.add(resultado.getObject("nombre").toString().trim());
                miembros.add(resultado.getObject("valX"));
                miembros.add(resultado.getObject("valY"));
                miembros.add(resultado.getObject("ancho"));
                miembros.add(resultado.getObject("alto"));
                miembros.add(resultado.getObject("tipoLetra").toString().trim());
                miembros.add(resultado.getObject("color"));
                miembros.add(resultado.getObject("tamanoLetra"));
                miembros.add(resultado.getObject("IDTipoCampo"));
                miembros.add(resultado.getObject("IDCampo"));
                miembros.add(resultado.getObject("tabIndex"));
                miembros.add(resultado.getObject("estiloLetra").toString().trim());


                /*for (int i = 0; i < campos.size(); i++) {
                miMapa.put(campos.get(i).toString(), result.getObject(campos.get(i).toString()).toString());
                }*/
                /*  miMapa.put("correlativo",resultado.getObject("correlativo").toString());
                miMapa.put("nombre",resultado.getObject("nombre").toString());
                miMapa.put("descripcion",resultado.getObject("descripcion").toString());
                miMapa.put("ultimaActualizacion",resultado.getObject("ultimaActualizacion").toString());*/
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: aca?*" + e.toString());
        }
        /*
        miembros.add("id");
        miembros.add("nombre");
        miembros.add("valX");
        miembros.add("valY");
        miembros.add("ancho");
        miembros.add("alto");
        miembros.add("tipoLetra");
        miembros.add("color");
        miembros.add("tamanoLetra");
        miembros.add(resultado.getObject("tabIndex"));
        Map<String, String> mapaDatos = this.getResultSetMap(consulta,miembros);
        miembros.clear();
        miembros.add(mapaDatos.get("nombre"));
        miembros.add(mapaDatos.get("nombre"));
        miembros.add(mapaDatos.get("nombre"));
        miembros.add(mapaDatos.get("descripcion"));
        miembros.add(mapaDatos.get("ultimaActualizacion"));
        miembros.add(mapaDatos.get("nombre"));
        miembros.add(mapaDatos.get("nombre"));*/
        return miembros;
    }
}
