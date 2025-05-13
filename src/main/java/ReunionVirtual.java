import java.time.*;
import java.util.ArrayList;

public class ReunionVirtual extends Reunion{
    private String enlace;

    public ReunionVirtual(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, ArrayList<Invitacion> invitados, String enlace) {
        super(fecha, horaPrevista, duracionPrevista);
        this.enlace=enlace;
    }
}
