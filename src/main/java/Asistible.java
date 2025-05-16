import java.time.Instant;

public interface Asistible  {
    void asistir(Reunion reunion,Instant horaLLegada) throws ReunionNoEmpieza, ReunionFinalizada;

}
