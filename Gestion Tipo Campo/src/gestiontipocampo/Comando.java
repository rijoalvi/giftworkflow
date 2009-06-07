/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestiontipocampo;

/**
 *
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

    public void setNombre(String name){
        this.nombreComando = name;
    }
    
    public void setIDComando(int ID){
        this.IDComando = ID;
    }
    
    public int getIDComando(){
        return IDComando;
    }
    
    public void setIDFormulario(int ID){
        this.IDFormulario = ID;
    }
    
    public int getIDFormulario(){
        return IDFormulario;
    }



    public void setIDFormularioTrabajar(int idForm){
        this.IDFormularioTrabajar = idForm;
    }
    public void setTipoComando(int tipo){
        /*OJO: Orden de los comandos:
         1 - Comando de Crear
         2 - Comando de borrar
         3 - COmando de Modificar
         4 - Comando con Máscara
         */
        this.tipoComando = tipo;
        if(tipoComando!=4){
            facil=true;
        }
        else{
            facil=false;
        }
    }

    public void setDescripcion(String desc){
        this.descripcion = desc;
    }

    public void setFormularioDestino(String dest){
        this.formDestino = dest;
    }

    public void setTipoCampoInicial(String inicial){
        this.tipoCampoInicial = inicial;
    }

    public void setCondicionInicial(String inicio){
        this.condicionInicial = inicio;
    }

    public void setTipoCampoFinal(String fin){
        this.tipoCampoFinal = fin;
    }

    public void setCondicionFinal(String end){
        this.condicionFinal = end;
    }

    public String getNombre(){
        return(this.nombreComando);
    }
    
    public int getTipoComando(){
        return(this.tipoComando);
    }

    public String getDescripcion(){
        return(this.descripcion);
    }

    public String getFormularioDestino(){
        return(this.formDestino);
    }

    public String getTipoCampoInicial(){
        return(this.tipoCampoInicial);
    }

    public String getCondicionInicial(){
        return(this.condicionInicial);
    }

    public String getTipoCampoFinal(){
        return(this.tipoCampoFinal);
    }

    public String getCondicionFinal(){
        return(this.condicionFinal);
    }

    public boolean getFacil(){
        return(this.facil);
    }



    public int guardarComandoSinMascara(){
            int IDComandoAgregado=0;
            IDComandoAgregado = consultaComando.agregarComando(IDFormulario, nombreComando, descripcion, tipoComando , IDFormularioTrabajar,"fecha");
            System.out.print("Comando sin máscara agregado");
            return IDComandoAgregado;

    }
    public void guardarComandoConMascara(){
        consultaComando.agregarComandoConMascara(IDComando, tipoCampoInicial, condicionInicial, tipoCampoFinal, estadoFinal);
                      System.out.print("Comando con máscara agregado");
    }
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
}
