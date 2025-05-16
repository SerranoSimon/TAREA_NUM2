import java.time.*;
import java.util.ArrayList;


public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(tipoReunion tipoReunion,LocalDate fecha, Instant horaPrevista, Duration duracionPrevista,String sala)  {
        super(tipoReunion,fecha, horaPrevista, duracionPrevista);
        this.sala=sala;
    }
}
