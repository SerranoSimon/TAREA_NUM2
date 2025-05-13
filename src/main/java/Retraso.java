import java.time.Instant;
import java.time.Duration;
public class Retraso {
    private Empleado empleado;
    private Instant hora;
    private Duration duracion;

    public Retraso(Empleado empleado, Instant hora, Duration duracion) {
        this.empleado = empleado;
        this.hora = hora;
        this.duracion = duracion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Instant getHora() {
        return hora;
    }

    public Duration getDuracion() {
        return duracion;
    }
}
