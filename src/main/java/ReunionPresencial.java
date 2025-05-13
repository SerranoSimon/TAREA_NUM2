import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, ArrayList<Invitacion> invitados) {
        super(fecha, horaPrevista, duracionPrevista, invitados);
    }
}
