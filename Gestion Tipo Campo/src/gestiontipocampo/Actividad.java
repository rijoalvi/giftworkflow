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

    /**
     * Método que compara una instancia de actividad con la actividad a la que se le aplica
     * Se basa en el correlativo para ver si son iguales
     * @param Actividad o
     * @return true si la actividad enviada por parametro es igual a la que se le aplica el método, false en cualquier otro caso
     */
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
        //this.correlativo = consultaActividad.nuevaActividad(correlativoFlujo, nombre, descripcion, tipo, estadoInicial, estadoFinal, esSimple, repetible, masiva, requiereRevision, hitoDeControl, paralelo, exclusivo, obligatorio);
        this.correlativo = -1;
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
     * Constructor completo, recibe todos los datos y los guarda en la BD de una vez.
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
     * Guarda los datos de la actividad en la base de datos de configuración
     */
    public void crearActividad(){
        this.correlativo = consultaActividad.nuevaActividad(correlativoFlujo, nombre, descripcion, tipo, estadoInicial, estadoFinal, esSimple, repetible, masiva, requiereRevision, hitoDeControl, paralelo, exclusivo, obligatorio);
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

    /**
     * Método que obtiene el correlativo de la actidad
     * @return int correlativo
     */
    public int getCorrelativo() {
        return correlativo;
    }

    /**
     * Obtiene el correlativo del Flujo de Trabajo al que pertenece la actividad
     * @return int correlativo del Flujo de Trabajo
     */
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

    /**
     * Método que pregunta si la actividad es simple o no.
     * @return true en caso de que la actividad sea simple, false en caso contrario
     */
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

    /**
     * Método que
     * @param requiereRevision
     */
    public void setRequiereRevision(boolean requiereRevision) {
        this.requiereRevision = requiereRevision;
    }

    /**
     * Asigna a la actividad el valor para indicar si es simple o no
     * @param boolean simple
     */
    public void setSimple(boolean simple) {
        this.esSimple = simple;
    }

    /**
     * Obtiene la descripción de la Actividad
     * @return String descipción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna la descripción a la Actividad
     * @param String descripcion, indica la descripción de la Actividad
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la fecha de actualización de la Actividad
     * @return Date fechaActualizacion
     */
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * Establece la fecha de actualización de la Actividad
     * @param Date fechaActualizacion, fecha de la ultima actualización realizada a la Actividad
     */
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     *
     * Obtiene el nombre de la Actividad
     * @return String nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la Actividad
     * @param String nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Averigua si la Actividad es repetible o no
     * @return true si es repetible, false si no lo es
     */
    public boolean isRepetible() {
        return repetible;
    }

    /**
     * Establece si la Actividad será repetible o no
     * @param repetible
     */
    public void setRepetible(boolean repetible) {
        this.repetible = repetible;
    }

    /**
     * Obtiene el tipo de la Actividad
     * @return int Tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la Actividad
     * @param int tipo
     */

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Averigua si la Actividad es exclusiva o no
     * @return true si la Actividad es exclusiva, false en caso contrario
     */
    public boolean isExclusivo() {
        return exclusivo;
    }

    /**
     * Establece si la actividad es Exclusiva o no
     * @param bolean exclusivo
     */
    public void setExclusivo(boolean exclusivo) {
        this.exclusivo = exclusivo;
    }

    /**
     * Averigua si la Actividad es de caracter obligatorio o no
     * @return bolean True si es obligatorio, false en caso contrario
     */
    public boolean isObligatorio() {
        return obligatorio;
    }

    /**
     * Establece si la actividad es obligatoria o no
     * @param boolean obligatorio
     */
    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    /**
     * Averiagua si la activada es paralela o no
     * @return boolean True si la activadad es paralela
     */
    public boolean isParalelo() {
        return paralelo;
    }

    /**
     * Establece si la Actividad va a ser paralela o no
     * @param boolean paralelo
     */
    public void setParalelo(boolean paralelo) {
        this.paralelo = paralelo;
    }
}
