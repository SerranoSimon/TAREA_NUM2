import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.*;

/**
 * Clase que representa notas asociadas a una reunión, esto se guarda en un archivo txt.
 */
public class Nota {
    private Path rutaArchivo;
    private ArrayList<String> contenido;

    /**
     * crea un archivo de notas
     * @param nombreArchivo se refiere al nombre del archivo donde estará la nota.
     * @throws IOException si ocurre algún error con respecto al archivo.
     */
    public Nota(String nombreArchivo) throws IOException {
        this.contenido=new ArrayList<>();
        this.rutaArchivo = Paths.get(nombreArchivo);
        Files.write(rutaArchivo, Collections.emptyList(), StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);
    }

    /**
     * agrega una nota con su contenido y hora correspondiente al archivo.
     * @param texto se refiere al contenido de la nota
     * @param hora se refiere a la hora en la que se escribe la nota.
     */
    public void agregar(String texto, Instant hora) {
        String linea = "[" + hora.toString() + "] " + texto;
        contenido.add(linea);
        List<String> lineas = new ArrayList<>();
        contenido.sort(Comparator.comparing(nota -> {
            String fechaHora = nota.substring(1, nota.indexOf("]"));
            return Instant.parse(fechaHora);
        }));
        try {
            Files.write(rutaArchivo, contenido, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error guardando nota: " + e.getMessage());
        }

    }

    /**
     *metodo para leer la nota, es decir, su contenido.
     * @return retorna texto en una lista que representa el texto de las notas.
     * @throws IOException en caso de que ocurra un error al leer el contenido.
     */
    public ArrayList<String> leerNota() throws IOException {
        return (ArrayList<String>) Files.readAllLines(rutaArchivo);
    }

    @Override
    public String toString() {
        return "[Nota de la reunion, donde su contenido está en un archivo .txt]";
    }
}

