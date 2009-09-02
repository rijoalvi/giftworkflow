/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestiontipocampo;

import java.util.*;
public class Simetria extends TipoCampo{//puse tipo campo porque ocupe buscador, tons mas rapido, es tarde, luisk
    public Formulario formulario1;
    public Formulario formulario2;
    public String nombreForm1;
    public String nombreForm2;

    private int IDCampoLlaveForm1;
    private int IDCampoLlaveForm2;
    Vector vectorCamposForm1Seleccionados;
    Vector vectorCamposForm2Seleccionados;
    ConsultaSimetria consultaSimetria;
    public Simetria(){
        consultaSimetria = buscador.getConsultaSimetria();
    }
    public Simetria(String nombreForm1,String nombreForm2){
        this.nombreForm1=nombreForm1;
        this.nombreForm2=nombreForm2;
        consultaSimetria = buscador.getConsultaSimetria();
    }
    public void agregarSimetria(){
        try{
        //consultaSimetria=new ConsultaSimetria();

        String camposForm1="";
        for(int i =0; i < vectorCamposForm1Seleccionados.size();i++){
            camposForm1 += ((TipoCampo)vectorCamposForm1Seleccionados.get(i)).correlativo + ",";
            System.out.println(((TipoCampo)vectorCamposForm1Seleccionados.get(i)).correlativo + ","+((TipoCampo)vectorCamposForm1Seleccionados.get(i)).nombre);
        }
        camposForm1 = camposForm1.substring(0, camposForm1.length()-1);
        String camposForm2="";
        for(int i =0; i < vectorCamposForm2Seleccionados.size();i++){
            camposForm2 += ((TipoCampo)vectorCamposForm2Seleccionados.get(i)).correlativo+ ",";
            System.out.println(((TipoCampo)vectorCamposForm2Seleccionados.get(i)).correlativo + ","+((TipoCampo)vectorCamposForm2Seleccionados.get(i)).nombre);
        }
        camposForm2 = camposForm2.substring(0, camposForm2.length()-1);
        consultaSimetria.agregarSimetria(formulario1.correlativo, formulario2.correlativo, camposForm1, camposForm2,this.IDCampoLlaveForm1,this.IDCampoLlaveForm2);

        
        //consultaMaestroDetalle.agregarMaestroDetalle(0, "", 0, " ");
        }
        catch(Exception e){
            System.out.print("error: "+e.toString());
        }
    }

    public Vector obtenerTodasLasSimetricas(){
        consultaSimetria= new ConsultaSimetria();
        return consultaSimetria.obtenerTodasLasSimetrias();
    }
    @Override
    public String toString(){
        String cadena="";
        //cadena=this.formularioMaestro.toString()+"-"+this.formularioDetalle.toString();
        cadena="["+this.nombreForm1+"]-["+this.nombreForm2+"]";
        return cadena;
    }

    void setIDCampoLlaveForm1(TipoCampo campoLlaveForm1) {
        this.IDCampoLlaveForm1 = campoLlaveForm1.correlativo;
    }
    void setIDCampoLlaveForm2(TipoCampo campoLlaveForm2) {
        this.IDCampoLlaveForm2 = campoLlaveForm2.correlativo;
    }


}