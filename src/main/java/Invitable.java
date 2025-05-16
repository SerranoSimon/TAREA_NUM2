import java.time.Instant;

/**
 *Interfaz que representa la capacidad de un empleaod para ser invitado a una reunión.
 */
public interface Invitable {
    /**
     *permite la invitación de un empleado a une reunión.
     * @param invitacion invitación a la reunión.
     */
    public void invitar(Invitacion invitacion);
}
