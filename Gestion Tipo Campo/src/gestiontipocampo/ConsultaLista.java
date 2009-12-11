/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
package gestiontipocampo;
import java.util.*;
import java.sql.*;
/**
 *
 * @author luiscarlosch
 */
public abstract class  ConsultaLista extends ControladorBD{

    /**
     * Método abstracto que agrega un nuevo miembro a la base de datos
     * @param String nombreMiembro
     * @param int correlativo
     * @param int posicion
     */
    public abstract void agregarMiembro(String nombreMiembro,int correlativo , int posicion);

    /**
     * Método abstracto que obtiene el correlativo, nombre, descripcion, ultimaActualizacion, IDMiembroPorDefecto, conOrden, valor de la lista a la que pertenece el correlativo envidado por parámetro
     * @param int correlativo de la lista de la que se desean los datos
     * @return Mapa con los datos obtenidos, donde las claves son correlativo, nombre, descripcion, ultimaActualizacion, IDMiembroPorDefecto, conOrden, valor para obtener el correspondiente valor
     */
    public abstract Map<String, String> getInfoLista(int correlativo);

    /**
     * Obtiene los miembros de la lista indicada por el id enviado por parámetro
     * @param int ID de la lista de la que se requieren los miembros
     * @return Vector con los valores de los miembros de la lista
     */
    public Vector getMiembrosListaPorIDLista(int ID){

        Vector campos = new Vector();
        ResultSet resultado = null;

        //int tipoCampo;
        try {
            //resultado = this.getResultSet("select valor from MIEMBROLISTA where IDLista="+ID+";");//tengo que habilitar esta, pero es para que se muestre algo, luisk
            resultado = this.getResultSet("select valor from MIEMBROLISTA ;");
            while (resultado.next()) {
                campos.add(resultado.getObject("valor").toString());
            }

        }catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return campos;
    }
}
