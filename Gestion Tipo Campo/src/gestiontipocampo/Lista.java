/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontipocampo;

import java.util.*;

/**
 *
 * @author luiscarlosch@gmail.com
 */
/// <summary>
/// Clase que maneja los tipos de campo Lista
/// </summary>
public class Lista extends TipoCampo {

    private SortedSet miembroLista;
    public Modelo miModelo;
    public String nombreMiembroPorDefecto;
    public String IDMiembroPorDefecto;
    public boolean ordenPersonalizado;
    public ConsultaLista consultaLista;

    /// <summary>
    /// Constructor por defecto
    /// </summary>
    public Lista() {
        consultaLista = buscador.getConsultaLista();
        buscador = new ControladorBD();
        miembroLista = new TreeSet();
        miModelo = new Modelo();
        ordenPersonalizado = false;
    }

    /// <summary>
    /// Retorna un miembroLista
    /// </summary>
    /// <returns></returns>
    public SortedSet getMiembroListaSet() {
        return this.miembroLista;
    }

    /// <summary>
    /// Metodo que carga los miembros de la lista a partir de un vector
    /// </summary>
    /// <param name="vector"></param>
    public void setMiembrosLista(Vector vector) {
        miembroLista.clear();
        for (int i = 0; i < vector.size(); i++) {
            miembroLista.add(vector.get(i));
        }
    }

    /// <summary>
    /// Metodo que retorna todos los miembros de la lista, según el ID de ésta
    /// </summary>
    /// <param name="consulta"></param>
    /// <param name="campoTexto"></param>
    /// <param name="campoNumero"></param>
    /// <returns></returns>
    public Vector getModeloVector(String consulta, String campoTexto, String campoNumero) {
        return miModelo.getModeloEnVector(consulta, campoTexto, campoNumero);
    }

    /// <summary>
    /// Metodo que retorna todos los miembros de la lista, según el ID de ésta
    /// </summary>
    /// <param name="consulta"></param>
    /// <param name="campoTexto"></param>
    /// <param name="campoNumero"></param>
    /// <param name="campoNumero2"></param>
    /// <returns></returns>
    public Vector getModeloVector(String consulta, String campoTexto, String campoNumero, String campoNumero2) {
        return miModelo.getModeloEnVector(consulta, campoTexto, campoNumero, campoNumero2);
    }

    /// <summary>
    /// Metodo que retorna todos los miembros de la lista, según el ID de ésta
    /// </summary>
    /// <param name="ID"></param>
    /// <returns></returns>
    public Vector getMiembrosListaPorIDLista(int ID) {
        return consultaLista.getMiembrosListaPorIDLista(ID);
    }

    /// <summary>
    /// Metodo que carga en la clase Lista los datos respectivos de ésta, como nombre, descripcion y valor por defecto
    /// </summary>
    /// <returns></returns>
    public void setLista() {
        Map<String, String> miMapa;
        miMapa = consultaLista.getInfoLista(this.correlativo);

        this.nombre = miMapa.get("nombre");
        this.descripcion = miMapa.get("descripcion");
        this.IDMiembroPorDefecto = miMapa.get("IDMiembroPorDefecto");

        if (miMapa.get("conOrden").trim().equalsIgnoreCase("True")) {
            System.out.println(miMapa.get("conOrden"));
            this.ordenPersonalizado = true;
        } else {
            System.out.println(miMapa.get("conOrden") + "cogio false");
            this.ordenPersonalizado = false;
        }

        if (ControladorBD.conexionSeleccionada == 1) {
            this.nombreMiembroPorDefecto = miMapa.get("m.valor");
        } else {
            this.nombreMiembroPorDefecto = miMapa.get("valor");
        }
    }

    private int getID(Object obj) {
        int ID = 0;
        try {
            ID = ((MiDato) obj).ID;
        } catch (java.lang.ClassCastException e) {
            try {
                ID = ((MiDato2) obj).ID;
            } catch (java.lang.ClassCastException ex) {
            }
        }
        return ID;
    }

    /// <summary>
    /// Metodo que agrega un elemento a la lista
    /// </summary>
    /// <param name="nombreMiembro"></param>
    /// <param name="posicion"></param>
    public void agregarMiembro(String nombreMiembro, int posicion) {
        this.consultaLista.agregarMiembro(nombreMiembro, posicion, this.correlativo);

    }

    /// <summary>
    /// Metodo que borra un elemento de la lista
    /// </summary>
    /// <param name="miembro"></param>
    public void borrarMiembro(Object miembro) {
        buscador.doUpdate("delete from MIEMBROLISTA where correlativo = " + getID(miembro) + " and IDLista=" + this.correlativo + ";");
        this.miembroLista.remove(miembro);
    }

    /// <summary>
    /// Actualiza en la lista, el ID del miembro lista que ahora será el valor por defecto
    /// </summary>
    /// <param name="nombreMiembro"></param>
    /// <param name="IDMiembroPorDefecto"></param>
    public void upDateIDMiembroPorDefecto(String IDMiembroPorDefecto) {
        buscador.doUpdate("UPDATE LISTA  SET IDMiembroPorDefecto=" + IDMiembroPorDefecto + " where correlativo=" + this.correlativo + ";");
        //this.miembroLista.remove(miembro);
    }

    /// <summary>
    /// Actualiza en la lista el valor de un miembro de la lista
    /// </summary>
    /// <param name="miembroAActualizar"></param>
    /// <param name="valorNuevo"></param>
    public void upDateValorMiembro(Object miembroAActualizar, String valorNuevo) {
        int IDMiembroAActualizar = ((MiDato) (miembroAActualizar)).ID;
        buscador.doUpdate("Update MIEMBROLISTA set valor='" + valorNuevo + "' where Correlativo=" + IDMiembroAActualizar + ";");
        //this.miembroLista.remove(miembro);
        this.miembroLista.remove(miembroAActualizar);
        this.miembroLista.add(new MiDato(valorNuevo, IDMiembroAActualizar));
        if (("" + IDMiembroAActualizar).equalsIgnoreCase(this.IDMiembroPorDefecto)) {
            this.nombreMiembroPorDefecto = valorNuevo;
        }
    }

    /// <summary>
    /// Actualiza en la base de datos el valor del miembro de la lista que se modificó
    /// </summary>
    /// <returns></returns>
    public Vector setAndGetMiembrosVectorActualizados() {
        if (this.ordenPersonalizado) {
            this.setMiembrosLista(this.getModeloVector("select valor, ml.correlativo, ml.numeroElemento from MIEMBROLISTA ml, LISTA l where ml.IDLista=l.correlativo and l.correlativo=" + this.correlativo + "", "valor", "correlativo", "numeroElemento"));
        } else {
            this.setMiembrosLista(this.getModeloVector("select valor, ml.correlativo from MIEMBROLISTA ml, LISTA l where ml.IDLista=l.correlativo and l.correlativo=" + this.correlativo + "", "valor", "correlativo"));
        }

        SortedSet miembrosListaSet = new TreeSet();
        Vector miembrosListaVector = new Vector();

        miembrosListaSet = this.getMiembroListaSet();

        Iterator it = miembrosListaSet.iterator();

        while (it.hasNext()) {
            miembrosListaVector.add(it.next());
        }
        MiDato.valorDefecto = this.IDMiembroPorDefecto + "";
        return miembrosListaVector;
    }

    /// <summary>
    /// obtiene el modelo de los miembros de la lista
    /// </summary>
    /// <returns></returns>
    public Vector getModeloMiembrosVector() {
        //  this.setMiembrosLista(this.getModeloVector("select valor, ml.correlativo from MIEMBROLISTA ml, LISTA l where ml.IDLista=l.correlativo and l.correlativo="+this.correlativo+"", "valor", "correlativo"));
        MiDato.valorDefecto = this.IDMiembroPorDefecto;
        SortedSet miembrosListaSet = new TreeSet();
        Vector miembrosListaVector = new Vector();

        miembrosListaSet = this.getMiembroListaSet();

        Iterator it = miembrosListaSet.iterator();

        while (it.hasNext()) {
            miembrosListaVector.add(it.next());
        }

        return miembrosListaVector;
    }

    public void setConOrdenPersonalizado(boolean conOrden) {
        String orden;
        this.ordenPersonalizado = conOrden;
        if (conOrden) {
            orden = "True";
        } else {
            orden = "False";
        }
        buscador.doUpdate("UPDATE LISTA  SET conOrden = '" + orden + "' where correlativo = " + this.correlativo + ";");
    }

    /// <summary>
    /// Cambia la posicion del elemento de la lista
    /// </summary>
    /// <param name="ID"></param>
    /// <param name="posicion"></param>
    public void setOrdenDeElemento(int ID, int posicion) {
        buscador.doUpdate("UPDATE MIEMBROLISTA  SET numeroElemento = " + posicion + " where correlativo = " + ID + ";");
    }

    /// <summary>
    /// sobreescribe el método toString
    /// </summary>
    /// <returns></returns>
    @Override
    public String toString() {
        return super.toString();
    }
}
