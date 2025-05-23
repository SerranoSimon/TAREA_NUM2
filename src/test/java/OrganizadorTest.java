import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

class OrganizadorTest {

    @Test
    void escribir() throws IOException, ReunionFinalizada, ReunionNoEmpieza {
        Organizador o1 = new Organizador("101","Mora Muñoz","Pedro","pedromora@gmail.com");
        Empleado e1 = new Empleado("102","Chavez Hernandez","Carlos","carloschavez@gmail.com");
        Reunion r1 = new ReunionPresencial(tipoReunion.TECNICA, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"),1.5f ,"A1",o1);
        Departamento d1 = new Departamento("Departamento B");
        d1.addEmpleado(e1);
        d1.addEmpleado(o1);
        e1.invitar(r1.getInvitacion());
        r1.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        o1.asistir(r1,Instant.parse("2025-05-13T08:17:10Z"));
        e1.asistir(r1,Instant.parse("2025-05-13T08:17:20Z"));
        o1.escribir(r1,"La reunión ha comenzado a las: " + r1.getHoraInicio(),Instant.parse("2025-05-13T08:17:25Z"));
        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("[2025-05-13T08:17:25Z] La reunión ha comenzado a las: 2025-05-13T08:17:00Z");

        assertEquals(listaEsperada,r1.getNota().leerNota());

    }
}