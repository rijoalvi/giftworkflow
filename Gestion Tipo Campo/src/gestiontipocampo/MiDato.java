/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
package gestiontipocampo;

/**
 * Clase que sirve como par ordenado de dos cadenas de texto
 * @author luiscarlosch@gmail.com
 */
public class MiDato implements Comparable {

    public String nombre;
    public String descripcion;
    public int ID = 0;
    public static String valorDefecto;
/**
 * Constructor
 * @param nombre
 * @param ID
 */
    public MiDato(String nombre, int ID) {
        this.nombre = nombre;
        this.descripcion = "";
        this.ID = ID;
        valorDefecto = "";
    }
/**
 * Constructor que hace un par ordenado de dos textos
 * @param nombre
 * @param descripcion
 * @param ID
 */
    public MiDato(String nombre, String descripcion, int ID) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ID = ID;
        valorDefecto = "";
    }
/**
 * Operador de comparación
 * @param o
 * @return
 */
    @Override
    public int compareTo(Object o) {
        int aRetornar = this.nombre.toString().compareToIgnoreCase(o.toString());
        return aRetornar;
    }
/**
 * El objeto devuelva un String
 * @return
 */
    @Override
    public String toString() {
        return this.nombre;
    }
}
