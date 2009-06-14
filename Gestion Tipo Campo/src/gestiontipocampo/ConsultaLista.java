/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestiontipocampo;
import java.util.*;
import java.sql.*;
/**
 *
 * @author luiscarlosch
 */
public abstract class  ConsultaLista extends ControladorBD{
    public abstract void agregarMiembro(String nombreMiembro,int correlativo , int posicion);
    public abstract Map<String, String> getInfoLista(int correlativo);

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
