/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *

package gestiontipocampo;

import java.util.Vector;

/**
 * Clase para menejo de comandos
 * @author Alberto
 */
public class Comando  {
    
    public int IDComando;
    public String nombreComando; //El nombre del comando
    public int tipoComando;      //El tipo (creacion, con mascara, etc)
    public String descripcion;   //La descripcion
    public boolean conMascara;
    public boolean facil; //Aqui diferenciamos si es con mascara o es de los faciles. Si es facil es true, si es con mascara es false

    //ESTA ES LA OPCIÓN DE COMANDOS DE CREAR, BORRAR O MODIFICAR
    public String formDestino;   //El formulario que voy a crear/borrar/modificar (si es el caso)

    //ESTA ES LA OPCIÓN DE COMANDO CON MÁSCARA
    public int IDFormulario;

    public String tipoCampoInicial;
    public String condicionInicial;
    public String tipoCampoFinal;
    public String condicionFinal;
    
    public String estadoFinal;
    public int IDFormularioTrabajar;
    public ControladorBD buscador;
    public ConsultaComando consultaComando; //controlador BD de comando
    /**
     * Constructor por defecto
     */
    public Comando() {
        buscador = new ControladorBD();
        consultaComando=buscador.getConsultaComando();
        this.IDComando = -1;
        this.nombreComando = "";
        this.tipoComando = 0;
        this.descripcion = "";
        this.formDestino = "";
        this.tipoCampoInicial = "";
        this.condicionInicial = "";
        this.tipoCampoFinal = "";
        this.condicionFinal = "";
    }
    /**
     * Constructo que llena al objecto con un comando seleccionado
     * @param correlativo
     */
    public Comando(int correlativo){
        buscador = new ControladorBD();
        consultaComando=buscador.getConsultaComando();
        String[] datos = consultaComando.getComando(correlativo);
        this.IDComando = correlativo;
        this.IDFormulario = Integer.parseInt(datos[1]);
        this.nombreComando = datos[2];
        this.tipoComando = Integer.parseInt(datos[4]);
        this.descripcion = datos[3];
        this.formDestino = datos[5];
    }
/**
 * Establece el nombre del comando
 * @param name
 */
    public void setNombre(String name){
        this.nombreComando = name;
    }
    /**
     * Establece el ID del comando
     * @param ID
     */
    public void setIDComando(int ID){
        this.IDComando = ID;
    }
    /**
     * Devuelve el ID del comando
     * @return
     */
    public int getIDComando(){
        return IDComando;
    }
    /**
     * Establece el ID del formulario
     * @param ID
     */
    public void setIDFormulario(int ID){
        this.IDFormulario = ID;
    }
    /**
     * Devuelve el ID del formulario
     * @return
     */
    public int getIDFormulario(){
        return IDFormulario;
    }
    /**
     * Establece el ID del Flujo a trabajar
     * @param idForm
     */
    public void setIDFormularioTrabajar(int idForm){
        this.IDFormularioTrabajar = idForm;
    }
    /**
     * Establece el tipo de comando
     * @param tipo
     */
    public void setTipoComando(int tipo){
        /*OJO: Orden de los comandos:
         1 - Comando de Crear
         2 - Comando de Modificar
         3 - Comando de visualizar
         4 - Comando de borrar
         5 - Comando con Máscara
         */
        this.tipoComando = tipo;
        if(tipoComando!=5){
            facil=true;
        }
        else{
            facil=false;
        }
    }
    /**
     * Establece la Descripcion
     * @param desc
     */
    public void setDescripcion(String desc){
        this.descripcion = desc;
    }
    /**
     * Establece FormularioDestino
     * @param dest
     */
    public void setFormularioDestino(String dest){
        this.formDestino = dest;
    }
    /**
     *  Establece TipoCampoInicial
     * @param inicial
     */
    public void setTipoCampoInicial(String inicial){
        this.tipoCampoInicial = inicial;
    }
    /**
     *  Establece CondicionInicial
     * @param inicio
     */
    public void setCondicionInicial(String inicio){
        this.condicionInicial = inicio;
    }
    /**
     * Establece TipoCampoFinal
     * @param fin
     */
    public void setTipoCampoFinal(String fin){
        this.tipoCampoFinal = fin;
    }
    /**
     * Establece Condicion Final
     * @param end
     */
    public void setCondicionFinal(String end){
        this.condicionFinal = end;
    }
    /**
     * Devuelve nombreComando
     * @return nombreComando
     */
    public String getNombre(){
        return(this.nombreComando);
    }
    /**
     * Retorna tipo Comando
     * @return tipoComando
     */
    public int getTipoComando(){
        return(this.tipoComando);
    }
    /**
     * Retorna descripcion
     * @return descripcion
     */
    public String getDescripcion(){
        return(this.descripcion);
    }
    /**
     * FormularioDestino
     * @return Formulario Destino
     */
    public String getFormularioDestino(){
        return(this.formDestino);
    }
    /**
     * Retorna Tipo Campo Inicia
     * @return tipoCampoInicial
     */
    public String getTipoCampoInicial(){
        return(this.tipoCampoInicial);
    }
    /**
     * Retorna Condicion Inicial
     * @return condicionInicial
     */
    public String getCondicionInicial(){
        return(this.condicionInicial);
    }
    /**
     * Retorna tipoCampoFinal
     * @return tipoCampoFinal
     */
    public String getTipoCampoFinal(){
        return(this.tipoCampoFinal);
    }
    /**
     * retorna condicionFinal
     * @return condicionFinal
     */
    public String getCondicionFinal(){
        return(this.condicionFinal);
    }

    public boolean getFacil(){
        return(this.facil);
    }
    /**
     * Guarda un comando Sin Mascara
     * @return IDComandoAgregado
     */
    public int guardarComandoSinMascara(){
            int IDComandoAgregado=0;
            IDComandoAgregado = consultaComando.agregarComando(IDFormulario, nombreComando, descripcion, tipoComando , IDFormularioTrabajar,"fecha");
            System.out.print("Comando sin máscara agregado");
            return IDComandoAgregado;

    }
    /**
     * Guarda un comando Con Mascara
     */
    public void guardarComandoConMascara(){
        consultaComando.agregarComandoConMascara(IDComando, tipoCampoInicial, condicionInicial, tipoCampoFinal, estadoFinal);
                      System.out.print("Comando con máscara agregado");
    }
    /**
     * Guarda un comando
     */
    public void guardarComando(){        
        if(!conMascara){

            this.IDComando = consultaComando.agregarComando(IDFormulario, nombreComando, descripcion, tipoComando , IDFormularioTrabajar,"fecha");

            System.out.print("Comando sin máscara agregado");
        }
        else{
            //Si es la primer accion que se agrega, se debe agregar el comando primero
            //if(IDComando == -1 )
            //    this.IDComando = consultaComando.agregarComando(IDFormulario, nombreComando, descripcion, tipoComando , IDFormularioTrabajar,"fecha");
            consultaComando.agregarComandoConMascara(IDComando, tipoCampoInicial, condicionInicial, tipoCampoFinal, estadoFinal);
        }
    }

    /**
     * Retorna todos los comandos en un vector como para cargarlos en un combo
     * @return Vector con los datos de los comandos en este orden: correlativo, nombre
     */
    public Vector getTodosLosComandos(){
        Vector datos = consultaComando.obtenerTodosLosComandos();
        return datos;
    }
    /**
     * Retorna un comando
     * @param idForm
     * @return datos
     */
    public Vector getComandosFormulario(int idForm){
        Vector datos = consultaComando.obtenerComandosFormulario(idForm);
        return datos;
    }
}
