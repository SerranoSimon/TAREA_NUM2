import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class ReunionVirtual extends Reunion{
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, ArrayList<Invitacion> invitados) {
        super(fecha, horaPrevista, duracionPrevista, invitados);
    }
}
