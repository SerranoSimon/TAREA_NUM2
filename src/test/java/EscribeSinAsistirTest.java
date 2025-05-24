import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EscribeSinAsistirTest {
    @Test
    void EscribeSinAsistir() throws IOException, ReunionFinalizada, ReunionNoEmpieza {
        try {
            Organizador o1 = new Organizador("101", "Mora Muñoz", "Pedro", "pedromora@gmail.com");
            Reunion r1 = new ReunionPresencial(tipoReunion.TECNICA, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"), 1.5f, "A1", o1);
            o1.escribir(r1, "La reunión ha comenzado a las: " + r1.getHoraInicio(), Instant.parse("2025-05-13T08:17:25Z"));
        }catch (EscribeSinAsistir e){
            String esperado = "Estimado Organizador PedroMora Muñoz, no puede escribir pues aún no ha llegado a la reunión";
            assertEquals(esperado,e.getMessage());
        }

    }
}