/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *

package gestiontipocampo;

import java.util.*;
*/

/// <summary>
/// Clase que trabaja las relaci�nes sim�tricas entre formularios
/// </summary>
public class Simetria extends TipoCampo {//puse tipo campo porque ocupe buscador, tons mas rapido, es tarde, luisk

    public Formulario formulario1;
    public Formulario formulario2;
    public String nombreForm1;
    public String nombreForm2;
    private int IDCampoLlaveForm1;
    private int IDCampoLlaveForm2;
    Vector vectorCamposForm1Seleccionados;
    Vector vectorCamposForm2Seleccionados;
    ConsultaSimetria consultaSimetria;

    /// <summary>
    /// Constructor por defecto
    /// </summary>
    public Simetria() {
        consultaSimetria = buscador.getConsultaSimetria();
    }

    /// <summary>
    /// Constructor que realiza una simetr�a en el momento que se instancia
    /// </summary>
    /// <param name="nombreForm1"></param>
    /// <param name="nombreForm2"></param>
    public Simetria(String nombreForm1, String nombreForm2) {
        this.nombreForm1 = nombreForm1;
        this.nombreForm2 = nombreForm2;
        consultaSimetria = buscador.getConsultaSimetria();
    }

    /// <summary>
    /// Crea una relaci�n sim�trica entre 2 formularios
    /// </summary>
    public void agregarSimetria() {
        try {
            //consultaSimetria=new ConsultaSimetria();

            String camposForm1 = "";
            for (int i = 0; i < vectorCamposForm1Seleccionados.size(); i++) {
                camposForm1 += ((TipoCampo) vectorCamposForm1Seleccionados.get(i)).correlativo + ",";
                System.out.println(((TipoCampo) vectorCamposForm1Seleccionados.get(i)).correlativo + "," + ((TipoCampo) vectorCamposForm1Seleccionados.get(i)).nombre);
            }
            camposForm1 = camposForm1.substring(0, camposForm1.length() - 1);
            String camposForm2 = "";
            for (int i = 0; i < vectorCamposForm2Seleccionados.size(); i++) {
                camposForm2 += ((TipoCampo) vectorCamposForm2Seleccionados.get(i)).correlativo + ",";
                System.out.println(((TipoCampo) vectorCamposForm2Seleccionados.get(i)).correlativo + "," + ((TipoCampo) vectorCamposForm2Seleccionados.get(i)).nombre);
            }
            camposForm2 = camposForm2.substring(0, camposForm2.length() - 1);
            consultaSimetria.agregarSimetria(formulario1.correlativo, formulario2.correlativo, camposForm1, camposForm2, this.IDCampoLlaveForm1, this.IDCampoLlaveForm2);


            //consultaMaestroDetalle.agregarMaestroDetalle(0, "", 0, " ");
        } catch (Exception e) {
            System.out.print("error: " + e.toString());
        }
    }

    /// <summary>
    /// Devuelve una lista con todas las relaciones sim�tricas
    /// </summary>
    /// <returns></returns>
    public Vector obtenerTodasLasSimetricas() {
        consultaSimetria = new ConsultaSimetria();
        return consultaSimetria.obtenerTodasLasSimetrias();
    }

    /// <summary>
    /// Sobrecarga del operador toString, para que retorne los nombres de los dos elementos de la relaci�n
    /// </summary>
    /// <returns></returns>
    @Override
    public String toString() {
        String cadena = "";
        //cadena=this.formularioMaestro.toString()+"-"+this.formularioDetalle.toString();
        cadena = "[" + this.nombreForm1 + "]-[" + this.nombreForm2 + "]";
        return cadena;
    }

    /// <summary>
    /// guarda el correlativo de la que ser� la llve primaria del formulario 1
    /// </summary>
    /// <param name="campoLlaveForm1"></param>
    void setIDCampoLlaveForm1(TipoCampo campoLlaveForm1) {
        this.IDCampoLlaveForm1 = campoLlaveForm1.correlativo;
    }

    /// <summary>
    /// guarda el correlativo de la que ser� la llve primaria del formulario 2
    /// </summary>
    /// <param name="campoLlaveForm2"></param>
    void setIDCampoLlaveForm2(TipoCampo campoLlaveForm2) {
        this.IDCampoLlaveForm2 = campoLlaveForm2.correlativo;
    }
}
