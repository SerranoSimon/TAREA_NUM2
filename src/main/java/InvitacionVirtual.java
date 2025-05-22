import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class InvitacionVirtual extends Invitacion{
    private String enlace;
    /**
     * se crea una invitación a una reunión dirigida a los empleados.
     * se crea una lista vacía para llenar con los invitados a la reunión.
     *
     * @param hora             hora de invitación.
     * @param fecha
     * @param duracionPrevista
     * @param tipoReunion
     */
    public InvitacionVirtual(Instant hora, LocalDate fecha, Duration duracionPrevista, tipoReunion tipoReunion, String enlace) {
        super(hora, fecha, duracionPrevista, tipoReunion);
        this.enlace=enlace;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nEnlace: "+enlace+"]";
    }
}
