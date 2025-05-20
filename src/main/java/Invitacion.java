import java.time.Instant;
import java.util.ArrayList;

/**
 * Clase que representa lal invitación a una reunión.
 */
public class Invitacion {
    private Instant hora;
    private ArrayList<Persona> listaDeInvitados;

    /**
     *se crea una invitación a una reunión dirigida a los empleados.
     * se crea una lista vacía para llenar con los invitados a la reunión.
     * @param hora hora de invitación.
     */
    public Invitacion(Instant hora){
        this.hora=hora;
        this.listaDeInvitados=new ArrayList<>();
    }

    /**
     *metodo para obtener la hora de la invitación.
     * @return retorna la hora de la invitación.
     */
    public Instant getHora(){
        return hora;
    }

    /**
     *metodo para obtener la lista de invitados de una reunión.
     * @return retorna la lista de invitados.
     */
    public ArrayList<Persona> getListaDeInvitados() {
        return listaDeInvitados;
    }
}
