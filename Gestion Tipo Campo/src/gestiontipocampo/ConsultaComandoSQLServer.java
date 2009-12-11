/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *

package gestiontipocampo;

import java.sql.*;
import java.util.Vector;

/**
 * Clase donde están todas las consultas de SQLServer a la base de datos con la información de los comandos
 * @author luiscarlosch
 */
public class ConsultaComandoSQLServer extends ConsultaComando{
    /**
     * Agrega una tupla a la BD en la tabla COMANDO
     * @param CorrelativoFOrmulario
     * @param NombreComando
     * @param DescripcionComando
     * @param tipoComando
     * @param correlativoFormularioATrabajar
     * @param fechaActualizacion
     */
    public int agregarComando(int CorrelativoFormulario, String NombreComando, String DescripcionComando, int tipoComando, int correlativoFormularioATrabajar, String fechaActualizacion){
       // this.doUpdate("Insert Into FORMULARIO (nombre, descripcion) VALUES ('" + 45 + "', '" + 45 + "')");
        int IDComando = -1;
        this.doUpdate("INSERT INTO COMANDO (IDFormulario,Nombre,Descripcion,Tipo,IDFormularioATrabajar) VALUES ("  +CorrelativoFormulario+", '"+NombreComando+"','"+DescripcionComando+"',"+tipoComando+", "+correlativoFormularioATrabajar+")");


        try { //Se busca el ID de los datos que acaba de insertar
            ResultSet resultado = this.getResultSet("select top 1 ID from COMANDO  order by id desc;");//me parece que esta consulta es mejor
            if (resultado.next()) {
                IDComando = resultado.getInt("ID");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return IDComando;
    }

}
