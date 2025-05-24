import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AsisteSinSerInvitadoTest {
    @Test
    void AsisteSinSerInvitado() throws IOException  {
        try {
            Organizador o1 = new Organizador("201", "Parra Olivarez", "Lucas", "lucasparra@gmail.com");
            Reunion r1 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"), 26.0f, "A2", o1);
            InvitadoExterno i1 = new InvitadoExterno("Cristobal", "Neruda Artiaga", "cristobalneruda@gmail.com");
            r1.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
            i1.asistir(r1, Instant.parse("2025-05-13T08:17:00Z"));
        } catch (AsisteSinSerInvitado | ReunionNoEmpieza | ReunionFinalizada e) {
            String esperado = "Estimado/a CristobalNeruda Artiaga, no puede asistir a esta reunion ya que no está invitado";
            assertEquals(esperado, e.getMessage());
        }
    }


}