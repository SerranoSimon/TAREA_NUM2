import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

/**
 * Clase que hereda de invitación, en este caso representa una invitación a una reunión virtual.
 */
public class InvitacionVirtual extends Invitacion{
    private String enlace;
    /**
     * se crea una invitación a una reunión dirigida a los empleados.
     * se crea una lista vacía para llenar con los invitados a la reunión.
     *
     *@param hora hora de invitación (misma que la hora prevista de reunion).
     * @param fecha fecha de la reunión.
     * @param duracionPrevistaHoras duración estimada de la reunión.
     * @param tipoReunion tipo de reunión (TECNICA, MARKETING, OTRO)
     */
    public InvitacionVirtual(Instant hora, LocalDate fecha, float duracionPrevistaHoras, tipoReunion tipoReunion, String enlace) {

        super(hora, fecha, duracionPrevistaHoras, tipoReunion);
        this.enlace=enlace;
    }

    /**
     *
     * @return retorna el enlace de la reunión.
     */
    @Override
    public String toString() {
        return super.toString()+
                "\nEnlace: "+enlace+"]";
    }
}
