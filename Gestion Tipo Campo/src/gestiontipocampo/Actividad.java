/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontipocampo;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Actividad {

    private ControladorBD buscador;
    private ConsultaActividad consultaActividad; //controlador BD de Actividad
    private int correlativoFlujo;   //Es para el uso futuro, indica a que flujo pertenece
    private int correlativo;
    private String nombre;
    private String descripcion;
    private int tipo;           //Hay tres tipos: Inicial, Final y Tramite
    private String estadoInicial;
    private String estadoFinal;
    private Date fechaActualizacion;
    private boolean simple;
    private boolean repetible;
    private boolean masiva;
    private boolean requiereRevision;
    private boolean hitoDeControl;

    /**
     * Constructor simple de Actividad, todos los datos estan inicializado en -1, "", false.
     */
    public Actividad() {
        buscador = new ControladorBD();
        consultaActividad = buscador.getConsultaActividad();

        correlativoFlujo = -1;
        correlativo = -1;
        nombre = "";
        descripcion = "";
        tipo = -1;
        estadoInicial = "";
        estadoFinal = "";
        fechaActualizacion = null;
        simple = false;
        repetible = false;
        masiva = false;
        requiereRevision = false;
        hitoDeControl = false;
    }

    /**
     * Constructor que recibe como parametro el correlativo de una actividad creada
     * @param correlativo
     */
    public Actividad(int correlativo) {
        buscador = new ControladorBD();
        consultaActividad = buscador.getConsultaActividad();
        String[] datos = consultaActividad.getActividad(correlativo);
        this.correlativo = correlativo;
        this.nombre = datos[1];
        this.descripcion = datos[2];
        this.tipo = Integer.parseInt(datos[3]);
        this.estadoInicial = datos[4];
        this.estadoFinal = datos[5];
        this.fechaActualizacion = new Date(Long.parseLong(datos[6]));
        this.simple = Boolean.parseBoolean(datos[7]);
        this.repetible = Boolean.parseBoolean(datos[8]);
        this.masiva = Boolean.parseBoolean(datos[9]);
        this.requiereRevision = Boolean.parseBoolean(datos[10]);
        this.hitoDeControl = Boolean.parseBoolean(datos[11]);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isRepetible() {
        return repetible;
    }

    public void setRepetible(boolean repetible) {
        this.repetible = repetible;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
