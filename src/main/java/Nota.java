import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;

public class Nota {
    private Path contenido;

    public Nota(String nombreArchivo) throws IOException {
        this.contenido = Paths.get(nombreArchivo);
        Files.write(contenido, Collections.emptyList(), StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void agregar(String texto, Instant hora) {
        String linea = "[" + hora.toString() + "] " + texto;
        try {
            Files.write(contenido, Collections.singletonList(linea),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error escribiendo nota: " + e.getMessage());
        }
    }
    public ArrayList<String> leerNota() throws IOException {
        return (ArrayList<String>) Files.readAllLines(contenido);
    }
}

