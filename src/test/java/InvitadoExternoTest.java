import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InvitadoExternoTest {

    @Test
    void asistir() throws IOException, ReunionFinalizada, ReunionNoEmpieza {
        Organizador o2 = new Organizador("201", "Parra Olivarez", "Lucas", "lucasparra@gmail.com");
        Reunion r2 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"), 26.0f, "A2", o2);
        r2.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        o2.asistir(r2, Instant.parse("2025-05-13T08:17:00Z"));
        o2.asistir(r2, Instant.parse("2025-05-13T09:17:00Z"));
        ArrayList<Persona> listaEsperada = new ArrayList<>();
        listaEsperada.add(o2);
        assertEquals(listaEsperada, r2.obtenerAsistencias());

    }
    @Test
    void invitar() throws IOException {
        Organizador o2 =new Organizador("201","Parra Olivarez","Lucas","lucasparra@gmail.com");
        Reunion r2 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"),26.0f,"A2",o2);
        InvitadoExterno i1 = new InvitadoExterno("Cristobal","Neruda Artiaga","cristobalneruda@gmail.com");
        i1.invitar(r2.getInvitacion());
        i1.invitar(r2.getInvitacion());
        ArrayList<Persona> listaEsperada = new ArrayList<>();
        listaEsperada.add(o2);
        listaEsperada.add(i1);
        assertEquals(listaEsperada,r2.obtenerInvitados());
    }
}