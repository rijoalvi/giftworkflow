/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    ///Constructor por omision
    public TipoCampo(){
        buscador = new ControladorBD();
    }
    public TipoCampo(int tipoDeTipoCampo, String nombre, int correlativo){
        this.tipoDeTipoCampo=tipoDeTipoCampo;
        this.nombre=nombre;
        this.correlativo=correlativo;
    }
    @Override
    public String toString() {
        String aRetornar = this.nombre;
        return aRetornar;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descr) {
        this.descripcion = descr;
    }
    
}
