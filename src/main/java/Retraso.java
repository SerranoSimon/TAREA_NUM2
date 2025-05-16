import java.time.Instant;
import java.time.Duration;

/**
 * Clase que representa el retraso de un empleado a una reunión.
 * Proporciona información acerca de este retraso.
 */
public class Retraso {
    private Empleado empleado;
    private Instant hora;
    private Duration duracion;

    /**
     *
     * @param empleado se refiere al empleado que llegó tarde.
     * @param hora se refiere a la hora en la que llegó el empleado.
     * @param duracion se refiere a la duración del retraso del empleado.
     */
    public Retraso(Empleado empleado, Instant hora, Duration duracion) {
        this.empleado = empleado;
        this.hora = hora;
        this.duracion = duracion;
    }

    /**
     *metodo para obtener el empleado que llegó tarde.
     * @return retorna el empleado que llegó tarde.
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     *metodo para obtener la hora a la que llegó el empleado.
     * @return retorna la hora en la que llegó el empleado.
     */
    public Instant getHora() {
        return hora;
    }

    /**
     *metodo para obtener la duración del retraso con respecto a la hora de inicio de la reunión.
     * @return retorna la duración del retraso.
     */
    public Duration getDuracion() {
        return duracion;
    }
}
