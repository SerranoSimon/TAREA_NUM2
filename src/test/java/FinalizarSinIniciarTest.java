import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FinalizarSinIniciarTest {
    @Test
    void FinalizarSinIniciar() throws IOException{
        try {
            Organizador o1 = new Organizador("101", "Mora Muñoz", "Pedro", "pedromora@gmail.com");
            Reunion r1 = new ReunionPresencial(tipoReunion.TECNICA, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"), 1.5f, "A1", o1);
            r1.finalizar(Instant.parse("2025-05-13T08:18:00Z"));
        }catch (FinalizarSinIniciar e){
            String esperado = "No se puede finalizar la reunión si aún no ha iniciado";
            assertEquals(esperado,e.getMessage());
        }
    }

}