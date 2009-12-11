/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestiontipocampo;

/**
 *
 * @author luiscarlosch@gmail.com
 */
import java.util.*;
public class MaestroDetalle extends TipoCampo{//puse tipo campo porque ocupe buscador, tons mas rapido, es tarde, luisk
    public Formulario formularioMaestro;
    public Formulario formularioDetalle;
    public String nombreMaestro;
     public String nombreDetalle;

    Vector vectorCamposMaestroSeleccionados;
    Vector vectorCamposDetalleSeleccionados;
    ConsultaMaestroDetalle consultaMaestroDetalle;
    String detalleObligatorio;


    /**
     * Constructor por defecto
     */
    public MaestroDetalle(){
        consultaMaestroDetalle = buscador.getConsultaMaestroDetalle();
    }
    /**
     * Constructor sobrecargado que inicializa el nombre del formulario maestro y el nombre del formulario detalle
     * @param Stirng nombreMaestro
     * @param String nombreDetalle
     */
    public MaestroDetalle(String nombreMaestro,String nombreDetalle){
        this.nombreMaestro=nombreMaestro;
        this.nombreDetalle=nombreDetalle;
    }

    /**
     * Método que guarda en la base de datos la información del maestro detalle
     */
    public void agregarNuevoMaestroDetalle(){
        try{
            consultaMaestroDetalle=new ConsultaMaestroDetalle();
            int idMaestroDetalle = consultaMaestroDetalle.agregarMaestroDetalle(formularioMaestro.correlativo, formularioMaestro.nombre, formularioDetalle.correlativo, formularioDetalle.nombre,this.detalleObligatorio);
            consultaMaestroDetalle.agregarCamposEnRelacionMaestroDetalle(idMaestroDetalle,vectorCamposDetalleSeleccionados,vectorCamposMaestroSeleccionados);

        }
        catch(Exception e){
            System.out.print("error: "+e.toString());
        }
    }

    /**
     * Método que obtienen todas relaciones tipo Maestro detalle que se encuentran en la base de datos
     * @return Vector con todas las relaciones de tipo maestro detalle, en los indices pares se encuentran los pares y consecutivamente en los indices consecutivos se encuetra el detalle
     */
    public Vector obtenerTodosLosMaestroDetalle(){
        consultaMaestroDetalle= new ConsultaMaestroDetalle();
        return consultaMaestroDetalle.obtenerTodosLosMaestroDetalle();
    }
    @Override
    /**
     * Obtiene una representación en una cadena de caracteres de la relación Maestro-Detalle
     * @return String con la representacion de las relaciones tipo maestro detalle
     */
    public String toString(){
        String cadena="";
        //cadena=this.formularioMaestro.toString()+"-"+this.formularioDetalle.toString();
        cadena="["+this.nombreMaestro+"]-["+this.nombreDetalle+"]";
        return cadena;
    }

    /**
     * Método que recupera el id del formulario detalle al que hace referencia el formulario Maestro dueño del id enviado por parámetro
     * @param IDFormulario del maestro del detalle buscado
     * @return int id del Formulario Detalle del formulario indicado por parámetro
     */
    int IDDetalleDelMaestro(int IDFormulario) {
        consultaMaestroDetalle = new ConsultaMaestroDetalle();
        return consultaMaestroDetalle.IDDetalleDelMaestro(IDFormulario);
    }

    /**
     * Método que recupera el id del formulario Maestro del formulario indicado por el parámetro
     * @param int IDFormulario detalle del que se quiere conocer el maestro
     * @return int IDFormulario Maestro del formulario indicado en el parámetro
     */
    int IDMaestroDelDetalle(int IDFormulario) {
        consultaMaestroDetalle = new ConsultaMaestroDetalle();
        return consultaMaestroDetalle.IDMaestroDelDetalle(IDFormulario);
    }
}