/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestiontipocampo;

import java.util.Vector;

/**
 *
 * @author admin
 */
public abstract class ConsultaActividad extends ControladorBD{

    public ConsultaActividad(){

    }

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
    public abstract int nuevaActividad(int correlativoFlujo, String nombre, String descripcion, int tipo, String estadoInicial, String estadoFinal, boolean simple, boolean repetible, boolean masiva, boolean requiereRevision, boolean hitoDeControl, boolean paralelo, boolean exclusivo, boolean obligatorio);

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
    public abstract void actualizarActividad(int correlativo, int correlativoFlujo, String nombre, String descripcion, int tipo, String estadoInicial, String estadoFinal, boolean simple, boolean repetible, boolean masiva, boolean requiereRevision, boolean hitoDeControl, boolean paralelo, boolean exclusivo, boolean obligatorio);

    /**
     * Devuelve los datos de la actividad segun el correlativo
     * @param correlativo
     * @return String[] en este orden: correlativo, correlativoFlujo, nombre, descripcion, tipo, estadoInicial, estadoFinal, fechaActualizacion, simple, repetible, masiva, requiereRevision, hitoDeControl.
     */
    public abstract String[] getActividad(int correlativo);

    /**
     * Devuelve todas las actividades que esten creadas en la BD
     */
    public abstract Vector obtenerTodasLasActividades();

    /**
     * Elimina la actividad de la base de datos.
     * @param correlativo de la actividad a eliminar
     * @return 0 - Se elimino correctamente, 1 - Ya existe una instancia de actividad,
     */
    public abstract int eliminar(int correlativo);

    /**
     * Agrega comando a la base de datos como parte de la Actividad (se supone que esta actividad es simple). 
     * Si ya existe un comando en esta posicion (orden) se corre una posicion adelante (Tambien todos los comandos con la posicion posterior).
     * @param correlativoActividad - correlativo de la actividad
     * @param IDComando - correlativo del comando
     * @param orden - posicion en la que se inserta comando, 0 - primera posicion
     * @param esObligatorio - si es obligatorio
     */
    public abstract void agregarComando(int correlativoActividad, int IDComando, int orden, boolean esObligatorio);

    /**
     * Desvincula comando de la actividad (se supone que actividad es simple).
     * Hay que correr otros comandos para conservar el orden
     * @param correlativo
     * @param IDComando
     */
    public abstract void desvincularComando(int correlativo, int IDComando);

    /**
     * Desvincula dos actividades
     * @param correlativoMadre
     * @param correlativoHija
     */
    public abstract void desvincularActividad(int correlativoMadre, int correlativoHija);

    /**
     * crea vinculo entre dos actividades madre e hija, pone las hijas en orden
     * @param correlativoMadre
     * @param correlativoHija
     * @param orden
     * @param esObligatorio
     */
    public abstract void vincularActividad(int correlativoMadre, int correlativoHija, int orden, boolean esObligatorio);
}
