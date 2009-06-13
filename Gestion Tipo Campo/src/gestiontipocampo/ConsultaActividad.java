/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestiontipocampo;

/**
 *
 * @author admin
 */
public abstract class ConsultaActividad extends ControladorBD{

    public ConsultaActividad(){

    }

    /**
     * Devuelve los datos de la actividad segun el correlativo
     * @param correlativo
     * @return String[] en este orden: correlativo, nombre, descripcion, tipo, estadoInicial, estadoFinal, fechaActualizacion, simple, repetible, masiva, requiereRevision, hitoDeControl.
     */
    public abstract String[] getActividad(int correlativo);

}
