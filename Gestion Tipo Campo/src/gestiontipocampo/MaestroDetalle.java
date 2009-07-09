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
    Vector vectorCamposMaestroSeleccionados;
    Vector vectorCamposDetalleSeleccionados;
    ConsultaMaestroDetalle consultaMaestroDetalle;
    public void MaestroDetalle(){
        consultaMaestroDetalle = buscador.getConsultaMaestroDetalle();
    }
    public void agregarNuevoMaestroDetalle(){
        try{
        consultaMaestroDetalle=new ConsultaMaestroDetalle();

        consultaMaestroDetalle.agregarMaestroDetalle(formularioMaestro.correlativo, formularioMaestro.nombre, formularioDetalle.correlativo, formularioDetalle.nombre);

        
        //consultaMaestroDetalle.agregarMaestroDetalle(0, "", 0, " ");
        }
        catch(Exception e){
            System.out.print("error: "+e.toString());
        }
    }
}
