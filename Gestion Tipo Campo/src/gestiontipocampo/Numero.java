//package gestiontipocampo;

/// <summary>
/// Clase para el Tipo Campo Numero
/// </summary>
public class Numero extends TipoCampo {

    /**
     * Numero de decimales que se guardan y se muestran del numero
     */
    protected int numeroDecimales;
    /**
     * Mascara del numero
     */
    protected String mascara;
    /**
     * Valor por defecto
     */
    protected float valorDefecto;

    /// <summary>
    /// Constructor para crear un numero nuevo
    /// </summary>
    public Numero() {
    }

    /// <summary>
    /// Sobrecarga del operador toString del tipoCampoNumero
    /// </summary>
    /// <returns></returns>
    @Override
    public String toString() {
        String aRetornar =
                this.correlativo + "\n" +
                this.nombre + "\n" +
                this.descripcion + "\n";
        aRetornar += "Decimales: " + this.numeroDecimales + " \n" +
                this.mascara + "\n" +
                "Por Defecto: " + this.valorDefecto + "\n";
        return aRetornar;
    }

    /// <summary>
    /// Retorna la máscara que contiene la clase número
    /// </summary>
    /// <returns></returns>
    public String getMascara() {
        return mascara;
    }

    /// <summary>
    /// Guarda la máscara enviada como parámetro para el número en la base de datos
    /// </summary>
    /// <param name="mascara"></param>
    public void setMascara(String mascara) {
        this.mascara = mascara;
    }

    /// <summary>
    /// Retorna el número de decimales del núumero
    /// </summary>
    /// <returns></returns>
    public int getNumeroDecimales() {
        return numeroDecimales;
    }

    /// <summary>
    /// Guarda en la base de datos del número su número de decimales
    /// </summary>
    /// <param name="parent"></param>
    public void setNumeroDecimales(int numeroDecimales) {
        this.numeroDecimales = numeroDecimales;
    }

    /// <summary>
    /// Retorna el valor por defecto del número
    /// </summary>
    /// <returns></returns>
    public float getValorDefecto() {
        return valorDefecto;
    }

    /// <summary>
    /// Guarda en la base de datos el valor por defecto del número
    /// </summary>
    /// <param name="parent"></param>
    public void setValorDefecto(float valorDefecto) {
        this.valorDefecto = valorDefecto;
    }

    /// <summary>    
    /// Carga un tipoCampoNumero desde la base de datos
    /// </summary>
    /// <param name="ID"></param>
    /// <returns></returns>
    public int cargarNumero(int ID) {
        int estado = 0;

        return estado;
    }
}
