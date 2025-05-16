import java.time.*;
import java.util.ArrayList;

public class ReunionVirtual extends Reunion{
    private String enlace;

    public ReunionVirtual(tipoReunion tipoReunion,LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, ArrayList<Invitacion> invitados, String enlace) {
        super(tipoReunion,fecha, horaPrevista, duracionPrevista);
        this.enlace=enlace;
    }
}
