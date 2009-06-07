/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestiontipocampo;

import java.sql.*;

/**
 *
 * @author luiscarlosch
 */
public class ConsultaComando extends ControladorBD{
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
        this.doUpdate("INSERT INTO COMANDO (IDFormulario,Nombre,Descripcion,Tipo,IDFormularioATrabajar,FechaActualizacion) VALUES ("  +CorrelativoFormulario+", '"+NombreComando+"','"+DescripcionComando+"',"+tipoComando+", "+correlativoFormularioATrabajar+",'"+fechaActualizacion+"')");


        try { //Se busca el ID de los datos que acaba de insertar
            ResultSet resultado = this.getResultSet("select ID from COMANDO  order by id desc limit 1;");//me parece que esta consulta es mejor
            if (resultado.next()) {
                IDComando = resultado.getInt("ID");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return IDComando;
    }

    /**
     * Agrega una accion para el comando con mascara
     * @param IDComando
     * @param TipoCampoInicial
     * @param CondicionInicial
     * @param TipoCampoFinal
     * @param EstadoFinal
     */
    public void agregarComandoConMascara(int IDComando, String TipoCampoInicial,String CondicionInicial,String TipoCampoFinal,String EstadoFinal){
        //INSERT INTO ComandoMascara (IDComando,TipoCampoInicial,CondicionInicial,TipoCampoFinal,EstadoFinal) VALUES (1,'tipoCampoInicial','condicion inicial','campoFinal','dsfa');
        this.doUpdate("INSERT INTO COMANDOMASCARA (IDComando,TipoCampoInicial,CondicionInicial,TipoCampoFinal,EstadoFinal) VALUES ("+IDComando+",'"+TipoCampoInicial+"','"+CondicionInicial+"','"+TipoCampoFinal+"','"+EstadoFinal+"');");
    }

    public int agregarComandoConMascaraYObtenerID(int IDComando, String TipoCampoInicial,String CondicionInicial,String TipoCampoFinal,String EstadoFinal){
        //INSERT INTO ComandoMascara (IDComando,TipoCampoInicial,CondicionInicial,TipoCampoFinal,EstadoFinal) VALUES (1,'tipoCampoInicial','condicion inicial','campoFinal','dsfa');
        this.doUpdate("INSERT INTO  COMANDOMASCARA (IDComando,TipoCampoInicial,CondicionInicial,TipoCampoFinal,EstadoFinal) VALUES ("+IDComando+",'"+TipoCampoInicial+"','"+CondicionInicial+"','"+TipoCampoFinal+"','"+EstadoFinal+"');");


        return 0;
    }
}
