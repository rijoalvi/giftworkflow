/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontipocampo;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class Actividad implements Comparable{

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
    private boolean esSimple;     //True - esSimple, False - compuesta.
    private boolean repetible;
    private boolean masiva;
    private boolean requiereRevision;
    private boolean hitoDeControl;
    private boolean paralelo;
    private boolean exclusivo;
    private boolean obligatorio;

    @Override
    public int compareTo(Object o) {
        if( this.correlativo == ((Actividad)(o)).correlativo)
            return 0;
        return 1;
    }

    /**
     * Constructor esSimple de Actividad, todos los datos estan inicializado en -1, "", false.
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
        esSimple = false;
        repetible = false;
        masiva = false;
        requiereRevision = false;
        hitoDeControl = false;
        paralelo = false;
        exclusivo = false;
        obligatorio = false;
        this.correlativo = consultaActividad.nuevaActividad(correlativoFlujo, nombre, descripcion, tipo, estadoInicial, estadoFinal, esSimple, repetible, masiva, requiereRevision, hitoDeControl, paralelo, exclusivo, obligatorio);
        
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
        this.correlativoFlujo = Integer.parseInt(datos[1]);
        this.nombre = datos[2];
        this.descripcion = datos[3];
        this.tipo = Integer.parseInt(datos[4]);
        this.estadoInicial = datos[5];
        this.estadoFinal = datos[6];
        //this.fechaActualizacion = new Date(datos[7]);
        this.esSimple = Boolean.parseBoolean(datos[8]);
        this.repetible = Boolean.parseBoolean(datos[9]);
        this.masiva = Boolean.parseBoolean(datos[10]);
        this.requiereRevision = Boolean.parseBoolean(datos[11]);
        this.hitoDeControl = Boolean.parseBoolean(datos[12]);
        this.paralelo = Boolean.parseBoolean(datos[13]);
        this.exclusivo = Boolean.parseBoolean(datos[14]);
    }

    /**
     * Constructor completo, resibe todos los datos y los guarda en la BD de una vez.
     * @param correlativoFlujo
     * @param nombre
     * @param descripcion
     * @param tipo
     * @param estadoInicial
     * @param estadoFinal
     * @param esSimple
     * @param repetible
     * @param masiva
     * @param requiereRevision
     * @param hitoDeControl
     * @param paralelo
     * @param exclusivo
     * @param obligatorio
     */
    public Actividad(int correlativoFlujo, String nombre, String descripcion, int tipo, String estadoInicial, String estadoFinal, boolean simple, boolean repetible, boolean masiva, boolean requiereRevision, boolean hitoDeControl, boolean paralelo, boolean exclusivo, boolean obligatorio) {
        buscador = new ControladorBD();
        consultaActividad = buscador.getConsultaActividad();
        this.correlativo = consultaActividad.nuevaActividad(correlativoFlujo, nombre, descripcion, tipo, estadoInicial, estadoFinal, simple, repetible, masiva, requiereRevision, hitoDeControl, paralelo, exclusivo, obligatorio);
        this.correlativoFlujo = correlativoFlujo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estadoInicial = estadoInicial;
        this.estadoFinal = estadoFinal;
        this.esSimple = simple;
        this.repetible = repetible;
        this.masiva = masiva;
        this.requiereRevision = requiereRevision;
        this.hitoDeControl = hitoDeControl;
        this.paralelo = paralelo;
        this.exclusivo = exclusivo;
        this.fechaActualizacion = new Date();
    }

    /**
     * Metodo para actualizar los datos en la BD.
     */
    public void actualizar() {
        consultaActividad.actualizarActividad(correlativo, correlativoFlujo, nombre, descripcion, tipo, estadoInicial, estadoFinal, esSimple, repetible, masiva, requiereRevision, hitoDeControl, paralelo, exclusivo, obligatorio);
    }

    /**
     * Devuelve todas las actividades de la BD
     * @return vector de pares de string {correlativo, nombre}.
     */
    public Vector getTodasLasActividades() {
        Vector datos = consultaActividad.obtenerTodasLasActividades();
        return datos;
    }

    /**
     * Devuelve Actividades hijas de esta actividad (solamente se es actividad compuesta) o devuelve vector null
     * @return vector de actividades o null
     */
    public Actividad[] getHijasActividades() {
        Actividad[] actividades = null;
        int[] hijas = null;
        if (!isSimple()) {
            hijas = consultaActividad.getHijasActividades(correlativo);
            actividades = new Actividad[hijas.length];
            for (int i = 0; i < hijas.length; i++) {
                actividades[i] = new Actividad(hijas[i]);
            }
        }
        return actividades;
    }

    /**
     * Devuelve Comandos hijos de esta actividad (solamente si es actividad esSimple) o null
     * @return vector de comandos o null
     */
    public Comando[] getHijosComandos() {
        Comando[] comandos = null;
        int[] hijos = null;
        if (isSimple()) {
            hijos = consultaActividad.getHijosComandos(correlativo);
            comandos = new Comando[hijos.length];
            for(int i = 0; i < hijos.length; i++){
                comandos[i] = new Comando(hijos[i]);
            }
        }
        return comandos;
    }

    /**
     * Elimina la actividad actual. Si existen instancias basadas en esta actividad no se elimina
     * @return 0 - Actividad se elimino exitosamente, 1 - Ya existe una instancia, -1 - Actividad no inicializada.
     */
    public int eliminar() {
        int estado = -1;
        if (this.correlativo != -1) {
            estado = consultaActividad.eliminar(this.correlativo);
        }
        return estado;
    }

    /**
     * Agrega un comando a la actividad (solamente si es actividad esSimple)
     * @param correlativoComando - correlativo del comando a agregar
     * @param orden - orden (0 - primero), si ya existe un comando en esta posicion se corre una posicion adelante
     * @param esObligatorio - si es obligatorio.
     */
    public void agregarComando(Comando comando, int orden, boolean esObligatorio) {
        consultaActividad.agregarComando(this.correlativo, comando.IDComando, orden, esObligatorio);        
    }

    /**
     * Desvincula comando de la actividad (Solamente si es actividad esSimple)
     * @param comando a desvincular
     */
    public void desvincularComando(Comando comando) {
        consultaActividad.desvincularComando(this.correlativo, comando.IDComando);
    }

    /**
     * Agrega Actividad como actividad hija (Solamente para actividades comuestas)
     * @param actividadHija
     * @param orden (0 - primero), si ya existe una Actividad en esta posicion se corre una posicion adelante
     * @param esObligatorio
     */
    public void agregarActividadHija(Actividad actividadHija, int orden, boolean esObligatorio) {
        consultaActividad.vincularActividad(this.correlativo, actividadHija.correlativo, orden, esObligatorio);
    }

    /**
     * Desvincula Actividades (Solamente para actividades comuestas)
     * @param actividad
     */
    public void desvincularActividad(Actividad actividadHija) {
        consultaActividad.desvincularActividad(this.correlativo, actividadHija.correlativo);
    }

    /**
     * Clona la actividad con otro nombre (tambien en la BD)
     * @param nombreNuevo
     * @return Actividad clonada.
     */
    public Actividad replicar(String nombreNuevo) {
        Actividad replica = new Actividad();
        replica.correlativoFlujo = this.correlativoFlujo;
        replica.nombre = nombreNuevo;
        replica.descripcion = this.descripcion;
        replica.tipo = this.tipo;
        replica.estadoInicial = this.estadoInicial;
        replica.estadoFinal = this.estadoFinal;
        replica.fechaActualizacion = new Date();
        replica.esSimple = this.esSimple;
        replica.repetible = this.repetible;
        replica.masiva = this.masiva;
        replica.requiereRevision = this.requiereRevision;
        replica.hitoDeControl = this.hitoDeControl;
        replica.correlativo = consultaActividad.nuevaActividad(replica.correlativoFlujo, replica.nombre, replica.descripcion, replica.tipo, replica.estadoInicial, replica.estadoFinal, replica.esSimple, replica.repetible, replica.masiva, replica.requiereRevision, replica.hitoDeControl, replica.paralelo, replica.exclusivo, replica.obligatorio);
        return replica;
    }

    //Sets y gets.
    public int getCorrelativo() {
        return correlativo;
    }

    public int getCorrelativoFlujo() {
        return correlativoFlujo;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public boolean isHitoDeControl() {
        return hitoDeControl;
    }

    public boolean isMasiva() {
        return masiva;
    }

    public boolean isRequiereRevision() {
        return requiereRevision;
    }

    public boolean isSimple() {
        return esSimple;
    }

    public void setCorrelativoFlujo(int correlativoFlujo) {
        this.correlativoFlujo = correlativoFlujo;
    }

    public void setEstadoFinal(String estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public void setHitoDeControl(boolean hitoDeControl) {
        this.hitoDeControl = hitoDeControl;
    }

    public void setMasiva(boolean masiva) {
        this.masiva = masiva;
    }

    public void setRequiereRevision(boolean requiereRevision) {
        this.requiereRevision = requiereRevision;
    }

    public void setSimple(boolean simple) {
        this.esSimple = simple;
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

    public boolean isExclusivo() {
        return exclusivo;
    }

    public void setExclusivo(boolean exclusivo) {
        this.exclusivo = exclusivo;
    }

    public boolean isObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public boolean isParalelo() {
        return paralelo;
    }

    public void setParalelo(boolean paralelo) {
        this.paralelo = paralelo;
    }
}
