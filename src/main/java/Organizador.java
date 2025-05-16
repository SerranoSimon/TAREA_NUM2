import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class Organizador extends Empleado{
    public Organizador(String id, String apellidos, String nombre, String correo) {
        super(id, apellidos, nombre, correo);
    }
    public void escribir(Reunion reunion,String texto, Instant hora) throws IOException {
        reunion.getNota().agregar(texto,hora);
    }

}
