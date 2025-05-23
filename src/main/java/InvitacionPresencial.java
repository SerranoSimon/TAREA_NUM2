import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

/**
 * Clase que hereda de Invitación, en este caso representa una invitación a una reunión presencial.
 */
public class InvitacionPresencial extends Invitacion{
    private String sala;
    /**
     * se crea una invitación a una reunión dirigida a los empleados.
     * se crea una lista vacía para llenar con los invitados a la reunión.
     *
     * @param hora hora de invitación.
     * @param fecha fecha de reunión.
     * @param duracionPrevistaHoras duración estimada de la reunión.
     * @param tipoReunion tipo de reunión (TECNICA, MARKETING, OTRO).
     */
    public InvitacionPresencial(Instant hora, LocalDate fecha, float duracionPrevistaHoras, tipoReunion tipoReunion,String sala) {

        super(hora, fecha, duracionPrevistaHoras, tipoReunion);
        this.sala=sala;
    }

    /**
     *
     * @return retorna la sala de la reunión.
     */
    @Override
    public String toString() {
        return super.toString()+
                "\nSala: "+sala+"]";
    }

}
