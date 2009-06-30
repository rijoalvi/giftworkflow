/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontipocampo;

/**
 *
 * @author luiscarlosch@gmail.com
 */
public class MiDato implements Comparable {

    public String nombre;
    public String descripcion;
    public int ID = 0;
    public static String valorDefecto;

    public MiDato(String nombre, int ID) {
        this.nombre = nombre;
        this.descripcion = "";
        this.ID = ID;
        valorDefecto = "";
    }

    public MiDato(String nombre, String descripcion, int ID) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ID = ID;
        valorDefecto = "";
    }

    @Override
    public int compareTo(Object o) {
        int aRetornar = this.nombre.toString().compareToIgnoreCase(o.toString());
        return aRetornar;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
