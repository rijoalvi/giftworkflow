/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontipocampo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Ricardo
 */
public class ConsultaActividadMySQL extends ConsultaActividad {

    /**
     * Crea nueva Actividad en la base de datos y devuelve el correlativo de la Actividad recien creada.
     * @param correlativoFlujo
     * @param nombre
     * @param descripcion
     * @param tipo
     * @param estadoInicial
     * @param estadoFinal
     * @param simple
     * @param repetible
     * @param masiva
     * @param requiereRevision
     * @param hitoDeControl
     * @return correlativo de la Actividad
     */
    public int nuevaActividad(int correlativoFlujo, String nombre, String descripcion, int tipo, String estadoInicial, String estadoFinal, boolean simple, boolean repetible, boolean masiva, boolean requiereRevision, boolean hitoDeControl){
        String strSimple = new Boolean(simple).toString();
        String strRepetible = new Boolean(repetible).toString();
        String strMasiva = new Boolean(masiva).toString();
        String strRequiereRevision = new Boolean(requiereRevision).toString();
        String strHitoDeControl = new Boolean(hitoDeControl).toString();
        int ID = -1;


        this.doUpdate("Insert Into ACTIVIDAD (correlativoFlujo, nombre, descripcion, tipo, estadoInicial, estadoFinal, esSimple, repetible, masiva, requiereRevision, hitoDeControl) VALUES ('"+correlativoFlujo+"', '" + nombre + "', '" + descripcion + "', '"+tipo+"', '"+estadoInicial+"', '"+estadoFinal+"', '"+strSimple+"', '"+strRepetible+"', '"+strMasiva+"', '"+strRequiereRevision+"', '"+strHitoDeControl+"')");
        try { //Se busca el ID de los datos que acaba de insertar
            ResultSet resultado = this.getResultSet("select correlativo from ACTIVIDAD where nombre = '" + nombre + "'");
            if (resultado.next()) {
                ID = resultado.getInt("correlativo");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return(ID);
    }

    /**
     * Actualiza los datos de la Actividad existente en la base de datos.
     * @param correlativo
     * @param correlativoFlujo
     * @param nombre
     * @param descripcion
     * @param tipo
     * @param estadoInicial
     * @param estadoFinal
     * @param simple
     * @param repetible
     * @param masiva
     * @param requiereRevision
     * @param hitoDeControl
     */
    public void actualizarActividad(int correlativo, int correlativoFlujo, String nombre, String descripcion, int tipo, String estadoInicial, String estadoFinal, boolean simple, boolean repetible, boolean masiva, boolean requiereRevision, boolean hitoDeControl){
        String strSimple = new Boolean(simple).toString();
        String strRepetible = new Boolean(repetible).toString();
        String strMasiva = new Boolean(masiva).toString();
        String strRequiereRevision = new Boolean(requiereRevision).toString();
        String strHitoDeControl = new Boolean(hitoDeControl).toString();

        this.doUpdate("UPDATE ACTIVIDAD set correlativoFlujo = '"+correlativoFlujo+"', nombre = '" + nombre + "', descripcion= '" + descripcion + "', tipo = '"+tipo+"', estadoInicial = '"+estadoInicial+"', estadoFinal = '"+estadoFinal+"', esSimple = '"+strSimple+"', repetible = '"+strRepetible+"', masiva = '"+strMasiva+"', requiereRevision = '"+strRequiereRevision+"', hitoDeControl = '"+strHitoDeControl+"' WHERE correlativo = " + correlativo + ";");
    }

    /**
     * Devuelve los datos de la actividad segun el correlativo
     * @param correlativo
     * @return String[] en este orden: correlativo, correlativoFlujo, nombre, descripcion, tipo, estadoInicial, estadoFinal, fechaActualizacion, simple, repetible, masiva, requiereRevision, hitoDeControl.
     */
    public String[] getActividad(int correlativo){
        
        String[] retorno = null;

        return(retorno);
    }

    /**
     * Elimina la actividad de la base de datos.
     * @param correlativo de la actividad a eliminar
     * @return 0 - Se elimino correctamente, 1 - Ya existe una instancia de actividad,
     */
    public int eliminar(int correlativo){

        return(0);
    }

    /**
     * Agrega comando a la base de datos como parte de la Actividad (se supone que esta actividad es simple).
     * Si ya existe un comando en esta posicion (orden) se corre una posicion adelante (Tambien todos los comandos con la posicion posterior).
     * @param correlativoActividad - correlativo de la actividad
     * @param IDComando - correlativo del comando
     * @param orden - posicion en la que se inserta comando, 0 - primera posicion
     * @param esObligatorio - si es obligatorio
     */
    public void agregarComando(int correlativoActividad, int IDComando, int orden, boolean esObligatorio){

    }

    /**
     * Desvincula comando de la actividad (se supone que actividad es simple).
     * Hay que correr otros comandos para conservar el orden
     * @param correlativo
     * @param IDComando
     */
    public void desvincularComando(int correlativo, int IDComando){

    }

    /**
     * Desvincul
     * a dos actividades
     * @param correlativoMadre
     * @param correlativoHija
     */
    public void desvincularActividad(int correlativoMadre, int correlativoHija){

    }

    /**
     * crea vinculo entre dos actividades madre e hija, pone las hijas en orden
     * @param correlativoMadre
     * @param correlativoHija
     * @param orden
     * @param esObligatorio
     */
    public void vincularActividad(int correlativoMadre, int correlativoHija, int orden, boolean esObligatorio){

    }
}
