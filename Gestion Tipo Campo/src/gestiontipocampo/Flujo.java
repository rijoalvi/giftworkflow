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
    private int actividadRaiz;

    /**
     * Constructor simple que inicializa todo a null o -1.
     */
    public Flujo() {
        buscador = new ControladorBD();
        consultaFlujo = buscador.getConsultaFlujo();

        correlativo = -1;
        nombre = "";
        descripcion = "";
        actividadRaiz = -1;
    }

    /**
     * Constructor que recibe todos los parametros y guarda en la BD
     * @param nombre
     * @param descripcion
     * @param raiz
     */
    public Flujo(String nombre, String descripcion, int actividadRaiz) {
        buscador = new ControladorBD();
        consultaFlujo = buscador.getConsultaFlujo();

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.actividadRaiz = actividadRaiz;
        //crea el flujo en la BD
        this.correlativo = consultaFlujo.nuevoFlujo(nombre, descripcion, actividadRaiz);
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
        this.actividadRaiz = Integer.parseInt(datos.get(2));
    }

    /**
     * Actualiza la información del al actividad indicada por el parámetro IDActividad
     * @param int IDActividad indica la actividad a actualizar
     * @param int IDFlujo indica el nuevo id del flujo de trabajo al que pertenece la Actividad
     * @param int ordenEjecucion indica el número de la Actividad dentro del flujo de trabajo
     */
    public void actualizarActividad(int IDActividad, int IDFlujo, int ordenEjecucion){
        String consulta = "UPDATE ACTIVIDAD set correlativoFlujo = '" + IDFlujo + "', ordenEjecucion = '"+ ordenEjecucion +"' WHERE correlativo = " + IDActividad + ";";
        consultaFlujo.actualizarActividad(consulta);
    }

    /**
     * Actualiza los deatos de este flujo en la base de datos.
     */
    public void actualizar() {
        consultaFlujo.actualizar(this.correlativo, this.nombre, this.descripcion, this.actividadRaiz);
    }

    /**
     * Metodo para borrar flujo de la base de datos
     */
    public void borrar(){
        consultaFlujo.borrarFlujo(this.correlativo);
        this.nombre = "";
        this.descripcion = "";
        this.correlativo = -1;
        this.actividadRaiz = -1;
    }

    /**
     * Metodo para probar si ya existe un flujo con el nombre dado
     * @param tempNombre - nombre a probar
     * @return true - ya existe, false - no hay flujo con este nombre
     */
    public static boolean yaExiste(String tempNombre){
        ControladorBD cont = new ControladorBD();
        ConsultaFlujo consulta = cont.getConsultaFlujo();
        boolean resultado = consulta.yaExiste(tempNombre);
        return resultado;
    }

    /**
     * obtiene el correlativo del Flujo de trabajo
     * @return int correlativo
     */
    public int getCorrelativo() {
        return correlativo;
    }

    /**
     * Obtiene la descripcion del flujo de trabajo
     * @return String descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripcion del Flujo de trabajo
     * @param String descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el nombre del flujo de trabajo
     * @return String nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del flujo de trabajo
     * @param String nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Obtiene el ID de la actividad raíz de la base de datos
     * @return int id de la actidada raíz
     */
    public int getRaiz() {
        return actividadRaiz;
    }

    /**
     * Establece la actividad raíz del flujo de trabajo
     * @param int actividadRaiz Correlativo de la actividad que será la actividad raíz del flujo de trabajo
     */
    public void setRaiz(int actividadRaiz) {
        this.actividadRaiz = actividadRaiz;
    }
}
