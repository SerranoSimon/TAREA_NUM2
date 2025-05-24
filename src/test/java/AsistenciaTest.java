import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AsistenciaTest {


    @Test
    void getListaDeAsistencia() throws IOException, ReunionFinalizada, ReunionNoEmpieza {
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
        r1.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        o1.asistir(r1,Instant.parse("2025-05-13T08:17:10Z"));
        e2.asistir(r1,Instant.parse("2025-05-13T08:17:15Z"));
        e1.asistir(r1,Instant.parse("2025-05-13T08:17:20Z"));
        ArrayList<Persona> listaEsperada = new ArrayList<>();
        listaEsperada.add(o1);
        listaEsperada.add(e2);
        listaEsperada.add(e1);
        assertEquals(listaEsperada,r1.getAsistencia().getListaDeAsistencia());

    }

    @Test
    void getInformacionRetrasos() throws IOException, ReunionFinalizada, ReunionNoEmpieza {
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
        r1.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        o1.asistir(r1,Instant.parse("2025-05-13T08:17:10Z"));
        e2.asistir(r1,Instant.parse("2025-05-13T08:17:15Z"));
        e1.asistir(r1,Instant.parse("2025-05-13T08:17:20Z"));
        ArrayList<String> listaRetrasoEsperada = new ArrayList<>();
        listaRetrasoEsperada.add(o1+" llegó a las 2025-05-13T08:17:10Z");
        listaRetrasoEsperada.add(e2+" llegó a las 2025-05-13T08:17:15Z");
        listaRetrasoEsperada.add(e1+" llegó a las 2025-05-13T08:17:20Z");
        assertEquals(listaRetrasoEsperada,r1.getAsistencia().getInformacionRetrasos());
    }
}