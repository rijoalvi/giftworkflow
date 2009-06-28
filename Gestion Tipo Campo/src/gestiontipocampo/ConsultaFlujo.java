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
public abstract class ConsultaFlujo extends ControladorBD {

    public ConsultaFlujo() {
    }

    /**
     * Crea nuevo flujo en la BD y devuelve el correlativo del flujo recien creado.
     * @param nombre
     * @param descripcion
     * @param correlativoRaiz - correlativo de la actividad en la raiz del flujo
     * @return correlativo del flujo recien creado.
     */
    public abstract int nuevoFlujo(String nombre, String descripcion, int correlativoRaiz);

    /**
     * Metodo que recupera datos de un flujo ya creado y devuelve los datos en un vector
     * @param correlativo
     * @return //Los datos tienen que ir en el siguiente orden: nombre, descripcion, raiz
     */
    public abstract Vector<String> getFlujo(int correlativo);

    /**
     * Matodo para actualizar los datos de un flujo ya creado en la BD
     * @param correlativo
     * @param nombre
     * @param descripcion
     * @param raiz
     */
    public abstract void actualizar(int correlativo, String nombre, String descripcion, int raiz);
}
