import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InvitacionTest {

    @Test
    void getListaDeInvitados() throws IOException {
        Organizador o1 = new Organizador("101","Mora Muñoz","Pedro","pedromora@gmail.com");
        Empleado e1 = new Empleado("102","Chavez Hernandez","Carlos","carloschavez@gmail.com");
        Empleado e2 = new Empleado("103","Chavez Zapata","Maria","mariachavez@gmail.com");
        Reunion r1 = new ReunionPresencial(tipoReunion.TECNICA, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"),1.5f ,"A1",o1);
        Departamento d1 = new Departamento("Departamento B");
        d1.addEmpleado(e1);
        d1.addEmpleado(o1);
        d1.addEmpleado(e2);
        e1.invitar(r1.getInvitacion());
        e2.invitar(r1.getInvitacion());
        ArrayList<Persona> listaEsperada = new ArrayList<>();
        listaEsperada.add(o1);
        listaEsperada.add(e1);
        listaEsperada.add(e2);
        assertEquals(listaEsperada,r1.getInvitacion().getListaDeInvitados());

    }
}