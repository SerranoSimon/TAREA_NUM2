import java.io.IOException;
import java.time.*;
import java.util.ArrayList;


public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(tipoReunion tipoReunion,LocalDate fecha, Instant horaPrevista, Duration duracionPrevista,String sala, Organizador organizador) throws IOException {
        super(tipoReunion,fecha, horaPrevista, duracionPrevista, organizador);
        this.sala=sala;
    }
}
