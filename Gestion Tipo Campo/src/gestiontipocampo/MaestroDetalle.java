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

    public MaestroDetalle(){
        consultaMaestroDetalle = buscador.getConsultaMaestroDetalle();
    }

    public MaestroDetalle(String nombreMaestro,String nombreDetalle){
        this.nombreMaestro=nombreMaestro;
        this.nombreDetalle=nombreDetalle;
    }

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

    public Vector obtenerTodosLosMaestroDetalle(){
        consultaMaestroDetalle= new ConsultaMaestroDetalle();
        return consultaMaestroDetalle.obtenerTodosLosMaestroDetalle();
    }
    @Override
    public String toString(){
        String cadena="";
        //cadena=this.formularioMaestro.toString()+"-"+this.formularioDetalle.toString();
        cadena="["+this.nombreMaestro+"]-["+this.nombreDetalle+"]";
        return cadena;
    }

    int IDDetalleDelMaestro(int IDFormulario) {
        consultaMaestroDetalle = new ConsultaMaestroDetalle();
        return consultaMaestroDetalle.IDDetalleDelMaestro(IDFormulario);
    }

    int IDMaestroDelDetalle(int IDFormulario) {
        consultaMaestroDetalle = new ConsultaMaestroDetalle();
        return consultaMaestroDetalle.IDMaestroDelDetalle(IDFormulario);
    }
}