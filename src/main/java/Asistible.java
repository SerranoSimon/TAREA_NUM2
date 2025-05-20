import java.time.Instant;

/**
 *Interfaz que representa la capacidad de un empleado para asistir a una reunión.
 */
public interface Asistible  {
    /**
     *Define la información necesaria acerca del empleado que asiste a una reunión.
     * @param reunion se refiere a la reunión a la que se asiste.
     * @param horaLLegada se refiere a la hora a la que llega el empleado.
     * @throws ReunionNoEmpieza en caso de que la reunion no ha comenzado aún.
     * @throws ReunionFinalizada en caso de que la reunión ya ha terminado.
     */
    void asistir(Reunion reunion,Instant horaLLegada) throws ReunionNoEmpieza, ReunionFinalizada,AsisteSinSerInvitado;

}
