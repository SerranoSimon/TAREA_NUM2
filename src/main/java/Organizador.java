import java.io.IOException;
import java.time.Instant;

/**
 *Clase que representa al organizador de la reunión, hereda de empleado.
 */
public class Organizador extends Empleado{
    /**
     *Se crea un nuevo empleado con la capacidad adicional de escribir notas.
     * @param id ID del organizador.
     * @param apellidos apellidos del organizador.
     * @param nombre nombre del organizador.
     * @param correo correo del organizador.
     */
    public Organizador(String id, String apellidos, String nombre, String correo) {
        super(id, apellidos, nombre, correo);
    }

    /**
     * este metodo permite al organizador escribir la nota en una reunión.
     * @param reunion es la reunión sobre la cual se escribirá la nota.
     * @param texto es el contenido de la nota.
     * @param hora es la hora a la que se escribió la nota.
     * @throws IOException si ocurre algún error al escribir la nota.
     */
    public void escribir(Reunion reunion,String texto, Instant hora) throws IOException, EscribeSinAsistir{
        if(reunion.obtenerAsistencias().stream().anyMatch(persona -> persona==this)){
            reunion.getNota().agregar(texto,hora);
        }
        else{
            throw new EscribeSinAsistir("Estimado Organizador "+getNombre()+getApellidos()+", no puede escribir pues aún no ha llegado a la reunión");
        }
    }

    /**
     *
     * @return menciona información del empleado organizador.
     */
    @Override
    public String toString() {
        return "[Organizador: "+
                super.toString();
    }
}
