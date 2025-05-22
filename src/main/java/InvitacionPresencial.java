import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class InvitacionPresencial extends Invitacion{
    private String sala;
    /**
     * se crea una invitación a una reunión dirigida a los empleados.
     * se crea una lista vacía para llenar con los invitados a la reunión.
     *
     * @param hora             hora de invitación.
     * @param fecha
     * @param duracionPrevista
     * @param tipoReunion
     */
    public InvitacionPresencial(Instant hora, LocalDate fecha, Duration duracionPrevista, tipoReunion tipoReunion,String sala) {
        super(hora, fecha, duracionPrevista, tipoReunion);
        this.sala=sala;
    }
    @Override
    public String toString() {
        return super.toString()+
                "\nSala: "+sala+"]";
    }

}
