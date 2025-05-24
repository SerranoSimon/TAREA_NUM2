import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReunionFinalizadaTest {
    @Test
    void ReunionFinalizada() throws IOException {
        try {
            Organizador o4 = new Organizador("201", "Parra Olivarez", "Lucas", "lucasparra@gmail.com");
            Reunion r4 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"), 26.0f, "A2", o4);
            InvitadoExterno i1 = new InvitadoExterno("Cristobal", "Neruda Artiaga", "cristobalneruda@gmail.com");
            i1.invitar(r4.getInvitacion());
            r4.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
            r4.finalizar(Instant.parse("2025-05-14T10:17:00Z"));
            i1.asistir(r4, Instant.parse("2025-05-15T08:20:00Z"));

        } catch (ReunionFinalizada | ReunionNoEmpieza e) {
            String esperado2 = "Estimado/a CristobalNeruda Artiaga, ha llegado tarde, la reunión finalizó.";
            assertEquals(esperado2, e.getMessage());
        }

    }
}