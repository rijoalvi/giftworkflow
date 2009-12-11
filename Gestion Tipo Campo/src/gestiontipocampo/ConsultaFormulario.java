/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontipocampo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Alberto
 */
public abstract class ConsultaFormulario extends ControladorBD {



    /**
     * Retorna todos los formularios en un vector como para cargarlos en un combo
     * @return Vector con los datos del formulario en este orden: correlativo, nombre
     */
    public Vector obtenerTodosLosFormularios() {

        Vector campos = new Vector();
        ResultSet resultado = null;

        //int tipoCampo;
        try {
            resultado = this.getResultSet("select correlativo, nombre from FORMULARIO;");
            while (resultado.next()) {
                campos.add(resultado.getObject("correlativo").toString());
                campos.add(resultado.getObject("nombre").toString());
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return campos;
    }

    /**
     * Retorna todos los tipo campos contenidos en un formulario
     * @param idFormulario
     * @return Vector con todos los tipo campos con este orde: correlativo, nombre
     */
    public Vector obtenerMiembrosFormularios(int idFormulario) {

        Vector campos = new Vector();
        ResultSet resultado = null;

        //int tipoCampo;
        try {
            resultado = this.getResultSet("select correlativo, nombre, IDTipoCampo from MIEMBROFORMULARIO where IDFormulario=" + idFormulario + " and IDTipoCampo <> 0;");
            while (resultado.next()) {
                campos.add(resultado.getObject("correlativo").toString());
                campos.add(resultado.getObject("nombre").toString());
                campos.add(resultado.getObject("IDTipoCampo").toString());
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return campos;
    }

    /**
     * Obtiene todos los miembros que componen el formulario indicado por el correlativo enviado por parámetro
     * @param int idFormulario id del formulario del que se desaen los miembros
     * @return Vector que contiene los TipoCampo que contiene el formulario
     */
    public Vector obtenerMiembrosFormulariosSoloNombres(int idFormulario) {

        Vector campos = new Vector();
        ResultSet resultado = null;

        //int tipoCampo;
        try {
            resultado = this.getResultSet("select correlativo, nombre, IDTipoCampo from MIEMBROFORMULARIO where IDFormulario=" + idFormulario + " and esEtiqueta='false';");//and IDTipoCampo > 0
            while (resultado.next()) {
                //campos.add(resultado.getObject("nombre").toString());
                //campos.add(new MiDato(resultado.getObject("nombre").toString(),Integer.parseInt(resultado.getObject("correlativo").toString())));
                campos.add(new TipoCampo(0,resultado.getObject("nombre").toString(),Integer.parseInt(resultado.getObject("correlativo").toString())));

            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return campos;
    }

    /**
     * Guarda el nombre y la descripción de un nuevo formulario
     * @param String nombre del formulario a guardar
     * @param String descripcion del formulario a guardar
     * @return int Correlativo del formulario que fue guardado
     */
    public abstract int guardaFormulario(String nombre, String descripcion);

    /**
     * Agrega un nuevo miembro formulario a la BD
     * @param IDFormulario
     * @param nombre
     * @param valX
     * @param valY
     * @param tipoLetra
     * @param color
     * @param tamanoLetra
     * @param IDTP
     * @return El ID del nuevo miembro
     */
    public int agregarMiembro(int IDFormulario, String nombre, int valX, int valY, int ancho, int alto, String tipoLetra, int color, int tamanoLetra, int IDTP, int IDCC, int tabIndex, String estiloLetra){
        this.doUpdate("insert into MIEMBROFORMULARIO (IDFormulario, nombre, valX, valY, ancho, alto, tipoLetra, color, tamanoLetra, IDTipoCampo, IDCampo, tabIndex, estiloLetra, esEtiqueta) values ('" + IDFormulario + "', '" + nombre + "', " + valX + ", " + valY + ", " + ancho + ", " + alto + ", '" + tipoLetra + "', '" + color + "', '" + tamanoLetra + "', " + IDTP + ", " + IDCC + ", " + tabIndex + ", '" + estiloLetra + "', '"+ (1 == 0) +"');");
        int ID = -1;
        try { //Se busca el ID de los datos que acaba de insertar
            ResultSet resultado = this.getResultSet("select correlativo from MIEMBROFORMULARIO where nombre = '" + nombre + "' AND IDFormulario = " + IDFormulario + ";");
            if (resultado.next()) {
                ID = resultado.getInt("correlativo");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return ID;
    }


    /**
     * Agrega una etiqueta en el formulario indicado por el parámetro IDFormulario con todas las especificaciones que se envían por parámetro
     * @param IDFormulario
     * @param nombre
     * @param valX
     * @param valY
     * @param ancho
     * @param alto
     * @param tipoLetra
     * @param color
     * @param tamanoLetra
     * @param IDTP
     * @param IDCC
     * @param tabIndex
     * @param estiloLetra
     * @return int id de la etiquieta agregada en el formulario
     */
        public int agregarEtiq(int IDFormulario, String nombre, int valX, int valY, int ancho, int alto, String tipoLetra, int color, int tamanoLetra, int IDTP, int IDCC, int tabIndex, String estiloLetra){
        this.doUpdate("insert into MIEMBROFORMULARIO (IDFormulario, nombre, valX, valY, ancho, alto, tipoLetra, color, tamanoLetra, IDTipoCampo, IDCampo, tabIndex, estiloLetra, esEtiqueta) values ('" + IDFormulario + "', '" + nombre + "', " + valX + ", " + valY + ", " + ancho + ", " + alto + ", '" + tipoLetra + "', '" + color + "', '" + tamanoLetra + "', " + IDTP + ", " + IDCC + ", " + tabIndex + ", '" + estiloLetra + "', '"+ (1 == 1) +"');");
        int ID = -1;
        try { //Se busca el ID de los datos que acaba de insertar
            ResultSet resultado = this.getResultSet("select correlativo from MIEMBROFORMULARIO where nombre = '" + nombre + "' AND IDFormulario = " + IDFormulario + ";");
            if (resultado.next()) {
                ID = resultado.getInt("correlativo");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return ID;
    }

    /**
     * Borra un miembro formulario en la BD
     * @param ID
     */
    public abstract void borrarMiembro(int ID);

    /**
     * Modifica los datos del miembro
     * @param ID ID del miembro a modificar
     * @param nombre nuevo nombre que se le quiere poner al miembro del formulario
     * @param valX nuevo valor de x que se le va a dar al miembro del formulario
     * @param valY nuevo valor de y que se le va a dar al miembre del formulario
     * @param tipoLetra nuevo tipo de letra que se le asignará al miembro del formulario
     * @param color nuevo color que se le agregará al miembro del formulario
     * @param tamanoLetra nuevo tamaño de la letra que se le dará al miembro del formulario
     * @param IDTP Id del flujo de trabajo al que pertenece el formulario
     */
    public abstract void updateMiembro(int ID, String nombre, int valX, int valY, int ancho, int alto, String tipoLetra, int color, int tamanoLetra, int IDTP, int tabIndex, String estiloLetra);

    /**
     * Actualiza la posicion del componente
     * @param ID
     * @param valX
     * @param valY
     */
    public abstract void updatePosicion(int ID, int valX, int valY);

    /**
     * Actualiza el tab index
     * @param ID
     * @param tab
     */
    public abstract void updateTabIndex(int ID, int tab);

    /**
     * Modifica el nombre del formulario
     * @param nombre
     * @param ID
     */
    public abstract void modificarNombre(String nombre, int ID);

    /**
     * Modifica la descripcion del formulario
     * @param descp
     * @param ID
     */
    public abstract void modificarDescripcion(String descp, int ID);

    /**
     * Obtiene los datos del formulario
     * @param correlativo
     * @return Vector con los datos del formulario en este orden: nombre, descripcion, ultimaActualizacion
     */
    public abstract Vector obtenerDatosFormulario(int correlativo);

    /**
     * Obtiene todos los miembros del formulario y los retorna dentro de un vector
     * @param correlativoFormulario
     * @return
     */
    public abstract Vector obtenerMiembros(int correlativoFormulario);

    /**
     * Devuelve la lista de elementos de un tipoCampo Lista
     * @param correlativoLista
     * @return lista de elementos
     */
    public String[] obtenerListaDeLista(int correlativoLista) {
        String[] result;
        Vector<String> lista = new Vector<String>();
        String consulta = "Select valor, numeroElemento From MIEMBROLISTA Where IDLista = " + correlativoLista;
        ResultSet resultado = this.getResultSet(consulta);
        try {
            while (resultado.next()) {
                lista.add(resultado.getObject("valor").toString());
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: aca?*" + e.toString());
        }

        result = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            result[i] = lista.get(i);
        }

        return result;
    }
}
