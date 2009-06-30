/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestiontipocampo;

import java.sql.*;
import java.util.Vector;

/**
 *
 * @author luiscarlosch
 */
public abstract class ConsultaComando extends ControladorBD{
    /**
     * Agrega una tupla a la BD en la tabla COMANDO
     * @param CorrelativoFOrmulario
     * @param NombreComando
     * @param DescripcionComando
     * @param tipoComando
     * @param correlativoFormularioATrabajar
     * @param fechaActualizacion
     */
    public abstract int agregarComando(int CorrelativoFormulario, String NombreComando, String DescripcionComando, int tipoComando, int correlativoFormularioATrabajar, String fechaActualizacion);

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

    /**
     * Retorna todos los comandos en un vector como para cargarlos en un combo
     * @return Vector con los datos de los comandos en este orden: correlativo, nombre
     */
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

        public Vector obtenerComandosFormulario(int idForm) {
        Vector campos = new Vector();
        ResultSet resultado = null;
        //int tipoCampo;
        try {
            resultado = this.getResultSet("select ID, Nombre from COMANDO where IDFormulario = '"+idForm+"';");
            while (resultado.next()) {
                campos.add(resultado.getObject("ID").toString());
                campos.add(resultado.getObject("Nombre").toString());
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return campos;
    }

    public String[] getComando(int correlativo){
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
