
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa la invitación a una reunión.
 */
public class Invitacion {
    private Instant hora;
    private LocalDate fecha;
    private float duracionPrevistaHoras;
    private tipoReunion tipoReunion;
    private ArrayList<Persona> listaDeInvitados;


    /**
     * se crea una invitación a una reunión dirigida a los empleados e invitados externos con parámetros que representan la información de la invitación.
     *
     * @param hora hora de invitación (misma que la hora prevista de reunion).
     * @param fecha fecha de la reunión.
     * @param duracionPrevistaHoras un estimado de la duración de la reunión.
     * @param tipoReunion se refiere al tipo de la reunión (TECNICA, MARKETING, OTRO).
     */
    public Invitacion(Instant hora, LocalDate fecha, float duracionPrevistaHoras, tipoReunion tipoReunion){
        this.hora=hora;
        this.tipoReunion=tipoReunion;
        this.fecha=fecha;
        this.duracionPrevistaHoras=duracionPrevistaHoras;
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

    /**
     *
     * @return retorna la información asociada a la invitación (Tipo de reunión, fecha, hora, duración).
     */
    @Override
    public String toString() {
        return "INVITACION:"+
                "\n[Has sido invitado a una reunión de "+tipoReunion+
                "\nFecha: "+fecha+
                "\nHora: "+hora+
                "\nDuracion aproximada: "+duracionPrevistaHoras+"h";

    }
}
