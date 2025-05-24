import java.time.Instant;
import java.util.ArrayList;

/**
 * Clase que representa el registro de asistencia en una reunión.
 */
public class Asistencia {
    private Instant horaInicio;
    private ArrayList<Persona> listaDeAsistencia;
    private ArrayList<String> informacionRetrasos;

    /**
     * Constructor que inicializa la hora de inicio y la lista de asistencias, junto a la información de los retrasos.
     * @param horaInicio Se refiere a la hora en la cual comienza la reunión.
     *
     */
    public Asistencia(Instant horaInicio){
        this.horaInicio=horaInicio;
        this.listaDeAsistencia=new ArrayList<>();
        this.informacionRetrasos=new ArrayList<>();
    }

    /**
     * metodo para obtener la lista de empleados que asisten a una reunión.
     * @return retorna la lista de empleados asistentes.
     */
    public ArrayList<Persona> getListaDeAsistencia() {
        return listaDeAsistencia;
    }

    /**
     *se verifica si hubo un retraso al comparar la hora de llegada y la hora de inicio.
     * en caso de existir un retraso, se agregará a la lista de informacion de retrasos la persona junto a la hora a la que llegó.
     * @param horaLLegada hora a la que llegó el empleado.
     */
    public void Llegada(Instant horaLLegada){
        if(horaLLegada.isAfter(horaInicio)){
            informacionRetrasos.add(listaDeAsistencia.getLast().toString()+" llegó a las "+ horaLLegada);
        }
    }

    /**
     *metodo para obtener una lista de información acerca de los retrasos.
     * @return retorna una lista con información sobre los retrasos.
     */
    public ArrayList<String> getInformacionRetrasos(){
        return informacionRetrasos;
    }


    @Override
    public String toString() {
        return "Asistencia: Regristro que contiene la lista de asistencia e informacion sobre los retrasos";

    }
}
