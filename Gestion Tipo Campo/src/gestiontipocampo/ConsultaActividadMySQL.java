/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontipocampo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Ricardo
 */
public class ConsultaActividadMySQL extends ConsultaActividad {

    /**
     * Crea nueva Actividad en la base de datos y devuelve el correlativo de la Actividad recien creada.
     * @param correlativoFlujo
     * @param nombre
     * @param descripcion
     * @param tipo
     * @param estadoInicial
     * @param estadoFinal
     * @param simple
     * @param repetible
     * @param masiva
     * @param requiereRevision
     * @param hitoDeControl
     * @return correlativo de la Actividad
     */
    public int nuevaActividad(int correlativoFlujo, String nombre, String descripcion, int tipo, String estadoInicial, String estadoFinal, boolean simple, boolean repetible, boolean masiva, boolean requiereRevision, boolean hitoDeControl, boolean paralelo, boolean exclusivo, boolean obligatorio){
        
        //casting a String de cada variable boolean

        String strSimple = new Boolean(simple).toString();
        String strRepetible = new Boolean(repetible).toString();
        String strMasiva = new Boolean(masiva).toString();
        String strRequiereRevision = new Boolean(requiereRevision).toString();
        String strHitoDeControl = new Boolean(hitoDeControl).toString();
        String strParalelo = new Boolean(paralelo).toString();
        String strExclusivo = new Boolean(exclusivo).toString();
        int ID = -1;

        //metemos la vara en la base de datos y buscamos el correlativo de lo que acabamos de meter
        this.doUpdate("Insert Into ACTIVIDAD (correlativoFlujo, nombre, descripcion, tipo, estadoInicial, estadoFinal, esSimple, repetible, masiva, requiereRevision, hitoDeControl, paralelo, exclusivo) VALUES ('"+correlativoFlujo+"', '" + nombre + "', '" + descripcion + "', '"+tipo+"', '"+estadoInicial+"', '"+estadoFinal+"', '"+strSimple+"', '"+strRepetible+"', '"+strMasiva+"', '"+strRequiereRevision+"', '"+strHitoDeControl+"', '"+strParalelo+"', '"+strExclusivo+"')");
        try { //Se busca el ID de los datos que acaba de insertar
            ResultSet resultado = this.getResultSet("select correlativo from ACTIVIDAD where nombre = '" + nombre + "'");
            if (resultado.next()) {
                ID = resultado.getInt("correlativo");
            }
        } catch (SQLException e) {
            System.out.println("*SQL Exception: *" + e.toString());
        }
        return(ID);
    }

    /**
     * Actualiza los datos de la Actividad existente en la base de datos.
     * @param correlativo
     * @param correlativoFlujo
     * @param nombre
     * @param descripcion
     * @param tipo
     * @param estadoInicial
     * @param estadoFinal
     * @param simple
     * @param repetible
     * @param masiva
     * @param requiereRevision
     * @param hitoDeControl
     */
    public void actualizarActividad(int correlativo, int correlativoFlujo, String nombre, String descripcion, int tipo, String estadoInicial, String estadoFinal, boolean simple, boolean repetible, boolean masiva, boolean requiereRevision, boolean hitoDeControl, boolean paralelo, boolean exclusivo, boolean obligatorio){

        //Casting a String
        String strSimple = new Boolean(simple).toString();
        String strRepetible = new Boolean(repetible).toString();
        String strMasiva = new Boolean(masiva).toString();
        String strRequiereRevision = new Boolean(requiereRevision).toString();
        String strHitoDeControl = new Boolean(hitoDeControl).toString();
        String strParalelo = new Boolean(paralelo).toString();
        String strExclusivo = new Boolean(exclusivo).toString();


        //hacer el update
        this.doUpdate("UPDATE ACTIVIDAD set correlativoFlujo = '"+correlativoFlujo+"', nombre = '" + nombre + "', descripcion= '" + descripcion + "', tipo = '"+tipo+"', estadoInicial = '"+estadoInicial+"', estadoFinal = '"+estadoFinal+"', esSimple = '"+strSimple+"', repetible = '"+strRepetible+"', masiva = '"+strMasiva+"', requiereRevision = '"+strRequiereRevision+"', hitoDeControl = '"+strHitoDeControl+"', paralelo = '"+strParalelo+"', exclusivo = '"+strExclusivo+"' WHERE correlativo = " + correlativo + ";");
    }

    /**
     * Devuelve los datos de la actividad segun el correlativo
     * @param correlativo
     * @return String[] en este orden: correlativo, correlativoFlujo, nombre, descripcion, tipo, estadoInicial, estadoFinal, fechaActualizacion, simple, repetible, masiva, requiereRevision, hitoDeControl, paralelo, exclusivo, obligatorio.
     */
    public String[] getActividad(int correlativo){

        //se hace la consulta
        String consulta = "Select correlativo, correlativoFlujo, nombre, descripcion, tipo, estadoInicial, estadoFinal, fechaActualizacion, simple, repetible, masiva, requiereRevision, hitoDeControl, paralelo, exclusivo, obligatorio From FORMULARIO Where correlativo = " + correlativo;

        //llenamos un vector con los nombres de elementos de la consulta
        Vector campos = new Vector();
        campos.add("correlativo");
        campos.add("correlativoFlujo");
        campos.add("nombre");
        campos.add("descripcion");
        campos.add("tipo");
        campos.add("estadoInicial");
        campos.add("estadoFinal");
        campos.add("fechaActualizacion");
        campos.add("simple");
        campos.add("repetible");
        campos.add("masiva");
        campos.add("requiereRevision");
        campos.add("hitoDeControl");
        campos.add("paralelo");
        campos.add("exclusivo");

        //ahora llenamos el vector con los elementos propiamente de la consulta
        Map<String, String> mapaDatos = this.getResultSetMap(consulta, campos);
        campos.clear();
        campos.add(mapaDatos.get("correlativo"));
        campos.add(mapaDatos.get("correlativoFlujo"));
        campos.add(mapaDatos.get("nombre"));
        campos.add(mapaDatos.get("descripcion"));
        campos.add(mapaDatos.get("tipo"));
        campos.add(mapaDatos.get("estadoInicial"));
        campos.add(mapaDatos.get("estadoFinal"));
        campos.add(mapaDatos.get("fechaActualizacion"));
        campos.add(mapaDatos.get("simple"));
        campos.add(mapaDatos.get("repetible"));
        campos.add(mapaDatos.get("masiva"));
        campos.add(mapaDatos.get("requiereRevision"));
        campos.add(mapaDatos.get("hitoDeControl"));
        campos.add(mapaDatos.get("paralelo"));
        campos.add(mapaDatos.get("exclusivo"));

        //Ahora casting de vector a String[] para devolver lo que es
        String[] retorno = new String[campos.size()];
        campos.toArray(retorno);

        return(retorno);
    }

    /**
     * Elimina la actividad de la base de datos.
     * @param correlativo de la actividad a eliminar
     * @return 0 - Se elimino correctamente, 1 - Ya existe una instancia de actividad,
     */
    public int eliminar(int correlativo){

        int retorno;
        this.doUpdate("delete from ACTIVIDAD where correlativo = " + correlativo + ";");

        //di el retorno siempre va a ser cero porque no supe como hacer lo del menos uno que dice en el criterio de retorno
        retorno = 0;

        return(retorno);
    }


    //OJO QUE HAY QUE CAMBIAR LA TABLA PORQUE NO TIENE UNA COLUMNA DE ORDEN. HAY QUE DEFINIR ESTO MAÑANA

    /**
     * Agrega comando a la base de datos como parte de la Actividad (se supone que esta actividad es simple).
     * Si ya existe un comando en esta posicion (orden) se corre una posicion adelante (Tambien todos los comandos con la posicion posterior).
     * @param correlativoActividad - correlativo de la actividad
     * @param IDComando - correlativo del comando
     * @param orden - posicion en la que se inserta comando, 0 - primera posicion
     * @param esObligatorio - si es obligatorio
     */
    public void agregarComando(int correlativoActividad, int IDComando, int orden, boolean esObligatorio){
        String strEsObligatorio = new Boolean(esObligatorio).toString();

        this.doUpdate("Insert Into MIEMBROACTIVIDADSIMPLE (correlativoMadre, correlativoComando, orden, obligatorio) VALUES ('"+correlativoActividad+"', '" + IDComando + "', '" + orden + "', '"+strEsObligatorio+"')");
    }



    /**
     * Desvincula comando de la actividad (se supone que actividad es simple).
     * Hay que correr otros comandos para conservar el orden
     * @param correlativo  //OJO: NOTA: No encuentro como se va a hacer para mandar este correlativo como parametro, me parece que seria mas facil mandar el correlativoMadre pero bueno, yo programo lo que dice ahi, cualq vara me dicen y lo cambio, o lo cambio y ya=S
     * @param IDComando
     */
    public void desvincularComando(int correlativo, int IDComando){
        this.doUpdate("delete from MIEMBROACTIVIDADSIMPLE where correlativo = " + correlativo + " AND correlativoComando = "+ IDComando+";");
            }

    /**
     * Desvincula dos actividades
     * @param correlativoMadre
     * @param correlativoHija
     */
    public void desvincularActividad(int correlativoMadre, int correlativoHija){
        this.doUpdate("delete from MIEMBRO_ACTIVIDAD_COMPUESTA where correlativoMadre = " + correlativoMadre + " AND correlativoHija = "+ correlativoHija+";");

    }

    /**
     * crea vinculo entre dos actividades madre e hija, pone las hijas en orden
     * @param correlativoMadre
     * @param correlativoHija
     * @param orden
     * @param esObligatorio
     */
    public void vincularActividad(int correlativoMadre, int correlativoHija, int orden, boolean esObligatorio){
         String strEsObligatorio = new Boolean(esObligatorio).toString();

        this.doUpdate("Insert Into MIEMBRO_ACTIVIDAD_COMPUESTA (correlativoMadre, correlativoHija, orden, obligatorio) VALUES ('"+correlativoMadre+"', '" + correlativoHija + "', '" + orden + "', '"+strEsObligatorio+"')");
    }
}
