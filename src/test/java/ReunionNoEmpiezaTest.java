import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReunionNoEmpiezaTest {
    @Test
    void ReunionNoEmpieza() throws IOException{
        try {
            Organizador o3 = new Organizador("201", "Parra Olivarez", "Lucas", "lucasparra@gmail.com");
            Reunion r3 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"), 26.0f, "A2", o3);
            InvitadoExterno i1 = new InvitadoExterno("Cristobal", "Neruda Artiaga", "cristobalneruda@gmail.com");
            i1.invitar(r3.getInvitacion());
            i1.asistir(r3, Instant.parse("2025-05-13T07:17:00Z"));
            r3.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        } catch (ReunionNoEmpieza | ReunionFinalizada e) {
            String esperado1 = "Estimado/a CristobalNeruda Artiaga, ha llegado antes, la reunion aún no empieza.";
            assertEquals(esperado1, e.getMessage());
        }
    }

}