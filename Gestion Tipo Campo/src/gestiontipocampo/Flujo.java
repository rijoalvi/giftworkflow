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
public class Flujo {

    private ControladorBD buscador;
    private ConsultaFlujo consultaFlujo;
    private int correlativo;
    private String nombre;
    private String descripcion;
    private Actividad raiz;

    /**
     * Constructor simple que inicializa todo a null o -1.
     */
    public Flujo() {
        buscador = new ControladorBD();
        consultaFlujo = buscador.getConsultaFlujo();

        correlativo = -1;
        nombre = "";
        descripcion = "";
        raiz = null;
    }

    /**
     * Constructor que recibe todos los parametros y guarda en la BD
     * @param nombre
     * @param descripcion
     * @param raiz
     */
    public Flujo(String nombre, String descripcion, Actividad raiz) {
        buscador = new ControladorBD();
        consultaFlujo = buscador.getConsultaFlujo();

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.raiz = raiz;
        this.correlativo = consultaFlujo.nuevoFlujo(nombre, descripcion, raiz.getCorrelativo());
    }

    /**
     * Constructor que recibe correlativo y recupera los datos de la BD
     * @param correlativo
     */
    public Flujo(int correlativo) {
        buscador = new ControladorBD();
        consultaFlujo = buscador.getConsultaFlujo();

        Vector<String> datos = consultaFlujo.getFlujo(correlativo);
        this.correlativo = correlativo;
        this.nombre = datos.get(0);
        this.descripcion = datos.get(1);
        this.raiz = new Actividad(Integer.parseInt(datos.get(2)));
    }

    public void actualizar() {
        consultaFlujo.actualizar(this.correlativo, this.nombre, this.descripcion, this.raiz.getCorrelativo());
    }

    //Sets y gets
    public int getCorrelativo() {
        return correlativo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Actividad getRaiz() {
        return raiz;
    }

    public void setRaiz(Actividad raiz) {
        this.raiz = raiz;
    }
}
