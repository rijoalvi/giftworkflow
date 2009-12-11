/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
package gestiontipocampo;

/**
 *
 * @author Alberto
 */
public class MiembroFormulario implements Comparable {

    private int IDFormulario;
    private int correlativo;
    private String nombre;
    private int valX;
    private int valY;
    private int ancho;
    private int alto;
    private String tipoLetra;
    private int color;
    private int tamanoLetra;
    private int IDTipoCampo;
    private int IDCampo;
    private int tabIndex;
    private String estiloLetra;

    /**
     * Constructor por omision
     */
    public MiembroFormulario() {
    }

    /**
     * Constructor que recibe nada mas el ID
     */
    public MiembroFormulario(int ID) {
        this.correlativo = ID;
    }

    /**
     * Constructor que recibe parametros de inicialización
     * @param int ID
     * @param int IDForm
     * @param String nombre
     * @param int valX
     * @param int valY
     * @param int ancho
     * @param int alto
     * @param String tipoLetra
     * @param int color
     * @param int tamanoLetra
     * @param int IDTipoC
     * @param int IDCC
     * @param int tabIndex
     * @param String estiloLetra
     */
    public MiembroFormulario(int ID, int IDForm, String nombre, int valX, int valY, int ancho, int alto, String tipoLetra, int color, int tamanoLetra, int IDTipoC, int IDCC, int tabIndex, String estiloLetra) {
        this.correlativo = ID;
        this.IDFormulario = IDForm;
        this.nombre = nombre;
        this.valX = valX;
        this.valY = valY;
        this.ancho = ancho;
        this.alto = alto;
        this.tipoLetra = tipoLetra;
        this.color = color;
        this.tamanoLetra = tamanoLetra;
        this.IDTipoCampo = IDTipoC;
        this.IDCampo = IDCC;
        this.tabIndex = tabIndex;
        this.estiloLetra = estiloLetra;
    }

    /**
     * Compara dos miembroFormulario y devuelve 0 si tienen el correlativo igual
     * @param o miembroFormulario a comparar
     * @return 0 - tienen el mismo correlativo, 1 - tiene el correlativo diferente
     */
    public int compareTo(Object o) {
        int retorno = 1;
        if (this.correlativo == ((MiembroFormulario) o).correlativo) {
            retorno = 0;
        }
        return retorno;
    }

    /**
     * Se indica el nombre del miembro
     * @param y
     */
    public void setNombre(String name) {
        nombre = name;
    }

    /**
     * Se indica la posicion en X del miembro
     * @param x
     */
    public void setValX(int x) {
        valX = x;
    }

    /**
     * Se indica la posicion en Y del miembro
     * @param y
     */
    public void setValY(int y) {
        valY = y;
    }

    /**
     * Se indica el estilo de letra
     * @param estilo Posibles valores son (Plain, Bold, Italic, BoldItalic)
     */
    public void setEstiloLetra(String estilo){
        estiloLetra = estilo;
    }

    /**
     * Indica el correlativo(ID) del miembro
     * @return int corelativo del maestro detalle
     */
    public int getID() {
        return correlativo;
    }

    /**
     * Indica el ID del tipo campo del miembro
     * @return int Id del tipo de campo miembro de la actividad
     */
    public int getIDTipoCampo() {
        return IDTipoCampo;
    }

    /**
     * Indica el ID de del campo que forma parte del formulario
     * @return int tipoCampo
     */
    public int getIDCampo(){
        return IDCampo;
    }

    /**
     * Indica la posicion en X del miembro
     * @return int valor de x
     */
    public int getValX() {
        return valX;
    }

    /**
     * Indica la posicion en y del miembro
     * @return valor de Y
     */
    public int getValY() {
        return valY;
    }

    /**
     * Indica el ancho del miembro
     * int ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Indica el alto del miembro
     * @return int alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Devuelve el valor del nombre
     * @return String nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Indica el ID del formulario al cual pertenece el miembro
     * @return int idFormulario
     */
    public int getIDFormulario() {
        return IDFormulario;
    }

    /**
     * Indica el tamaño de letra del miembro
     * @return int tamanoLetra
     */
    public int getTamanoLetra() {
        return tamanoLetra;
    }

    /**
     * Indica el color del miembro
     * @return int color
     */
    public int getColor() {
        return color;
    }

    /**
     * Devuelve el tipo de Letra
     * @return String Tipo de letra del miembro
     */
    public String getTipoLetra() {
        return tipoLetra;
    }

    /**
     * Devuelve tab index que indica el orden en que es selecconado el miembro dentro del formulario
     *  @return int tab index
     */
    public int getTabIndex() {
        return tabIndex;
    }

    /**
     * Devuelve estilo de letra
     * @return String
     */
    public String getEstiloLetra(){
        return estiloLetra;
    }
}
