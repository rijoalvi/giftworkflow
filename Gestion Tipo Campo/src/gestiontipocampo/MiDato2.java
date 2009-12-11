/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 /
package gestiontipocampo;

/// <summary>
/// Clase contenedora de datos para utilizar en la clase lista
/// </summary>
public class MiDato2 implements Comparable {

    public int orden;
    public String nombre;
    public int ID;
    public static String valorDefecto;

    /// <summary>
    /// Constructor por defecto
    /// </summary>
    /// <param name="nombre"></param>
    /// <param name="orden"></param>
    public MiDato2(String nombre, int ID, int orden) {
        this.nombre = nombre;
        this.ID = ID;
        this.orden = orden;
        valorDefecto = "";
    }

    /// <summary>
    /// Sobrecarga del operador compareTo
    /// </summary>
    /// <param name="o"></param>
    /// <returns></returns>
    public int compareTo(Object o) {
        int aRetornar = this.nombre.toString().compareToIgnoreCase(o.toString());
        if (aRetornar == 0) {
            return 0;
        }
        return this.orden - ((MiDato2) o).orden;
    }

    /// <summary>
    /// sobrecarga del operador toString
    /// </summary>
    /// <returns></returns>
    @Override
    public String toString() {
        return this.nombre;
    }
}
