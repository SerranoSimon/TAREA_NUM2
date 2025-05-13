import java.time.*;
import java.util.ArrayList;


public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista,String sala)  {
        super(fecha, horaPrevista, duracionPrevista);
        this.sala=sala;
    }
}
