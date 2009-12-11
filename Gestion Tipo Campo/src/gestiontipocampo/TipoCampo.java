/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
package gestiontipocampo;

/**
 *
 * @author luiscarlosch@gmail.com
 */
public class TipoCampo {

    //lo cambie a INT, no c porq estaba en STRING - beto//mmm yo creo este cambio afecta algo q yo hice con las lista mm pero no me acuerdo, luisk
    protected int correlativo;
    protected String nombre;
    protected String descripcion;
    protected String ultimaActualizacion;
    protected ControladorBD buscador;
    public int tipoDeTipoCampo;
    /**
     * Constructor por defecto
     */
    public TipoCampo(){
        buscador = new ControladorBD();
    }

    /**
     * Constructor sobrecargado que inicializa los atributos tipoDeTipoCampo, nombre y correlativo con los valores enviados por parámetro
     * @param int tipoDeTipoCampo
     * @param String nombre
     * @param int correlativo
     */
    public TipoCampo(int tipoDeTipoCampo, String nombre, int correlativo){
        this.tipoDeTipoCampo=tipoDeTipoCampo;
        this.nombre=nombre;
        this.correlativo=correlativo;
    }
    @Override

    /**
     * Hace una reprentación del tipo de campo donde envia el nombre
     * @return String nombre
     */
    public String toString() {
        String aRetornar = this.nombre;
        return aRetornar;
    }

    /**
     * Obtiene el nombre del tipoCampo
     * @return String nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del tipoCampo
     * @param String nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del tipoCampo
     * @return String descripcion
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece la descripcion del tipoCampo
     * @param String descr
     */
    public void setDescripcion(String descr) {
        this.descripcion = descr;
    }
    
}
