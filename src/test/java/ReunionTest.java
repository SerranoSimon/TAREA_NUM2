import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {

    @Test
    void obtenerAsistencias() throws IOException, ReunionFinalizada, ReunionNoEmpieza {
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

        Organizador o2 =new Organizador("201","Parra Olivarez","Lucas","lucasparra@gmail.com");
        Reunion r2 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(),Instant.parse("2025-05-13T08:17:00Z"),26.0f,"A2",o2);
        r2.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        r2.finalizar(Instant.parse("2025-05-14T10:17:00Z"));
        ArrayList<Persona> listaEsperada1 = new ArrayList<>();


        assertEquals(listaEsperada,r1.obtenerAsistencias());
        assertEquals(listaEsperada1,r2.obtenerAsistencias());

    }

    @Test
    void obtenerInvitados() throws IOException {
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

        Organizador o2 =new Organizador("201","Parra Olivarez","Lucas","lucasparra@gmail.com");
        Reunion r2 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(),Instant.parse("2025-05-13T08:17:00Z"),26.0f,"A2",o2);
        r2.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        r2.finalizar(Instant.parse("2025-05-14T10:17:00Z"));
        ArrayList<Persona> listaEsperada1 = new ArrayList<>();
        listaEsperada1.add(o2);

        assertEquals(listaEsperada1,r2.obtenerInvitados());
        assertEquals(listaEsperada,r1.obtenerInvitados());

    }

    @Test
    void obtenerAusencias() throws IOException, ReunionFinalizada, ReunionNoEmpieza {
        Organizador o1 = new Organizador("101","Mora Muñoz","Pedro","pedromora@gmail.com");
        Empleado e1 = new Empleado("102","Chavez Hernandez","Carlos","carloschavez@gmail.com");
        Empleado e2 = new Empleado("103","Chavez Zapata","Maria","mariachavez@gmail.com");
        Reunion r1 = new ReunionPresencial(tipoReunion.TECNICA, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"),1.5f ,"A1",o1);
        Departamento d1 = new Departamento("Departamento B");
        d1.addEmpleado(e1);
        d1.addEmpleado(o1);
        d1.addEmpleado(e2);
        d1.invitar(r1.getInvitacion());
        r1.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        o1.asistir(r1,Instant.parse("2025-05-13T08:17:00Z"));
        r1.finalizar(Instant.parse("2025-05-13T09:47:00Z"));
        ArrayList<Persona> listaAusenciaEsperada = new ArrayList<>();
        listaAusenciaEsperada.add(e1);
        listaAusenciaEsperada.add(e2);

        assertEquals(listaAusenciaEsperada,r1.obtenerAusencias());

        Organizador o2 =new Organizador("201","Parra Olivarez","Lucas","lucasparra@gmail.com");
        Reunion r2 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(),Instant.parse("2025-05-13T08:17:00Z"),26.0f,"A2",o2);
        Empleado e4 =new Empleado("202","Oliveira Torres","Natalia","nataliaoliveira@gmail.com");
        e4.invitar(r2.getInvitacion());
        r2.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        e4.asistir(r2,Instant.parse("2025-05-13T08:17:00Z"));
        ArrayList<Persona> listaAusenciaEsperada1 = new ArrayList<>();
        o2.asistir(r2,Instant.parse("2025-05-13T08:17:00Z"));
        r2.finalizar(Instant.parse("2025-05-14T10:17:00Z"));
        assertEquals(listaAusenciaEsperada1,r2.obtenerAusencias());



    }

    @Test
    void obtenerTotalAsistencia() throws IOException, ReunionFinalizada, ReunionNoEmpieza {
        Organizador o1 = new Organizador("101","Mora Muñoz","Pedro","pedromora@gmail.com");
        Empleado e1 = new Empleado("102","Chavez Hernandez","Carlos","carloschavez@gmail.com");
        Empleado e2 = new Empleado("103","Chavez Zapata","Maria","mariachavez@gmail.com");
        Reunion r1 = new ReunionPresencial(tipoReunion.TECNICA, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"),1.5f ,"A1",o1);
        Departamento d1 = new Departamento("Departamento B");
        d1.addEmpleado(e1);
        d1.addEmpleado(o1);
        d1.addEmpleado(e2);
        d1.invitar(r1.getInvitacion());
        r1.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        o1.asistir(r1,Instant.parse("2025-05-13T08:17:10Z"));
        e2.asistir(r1,Instant.parse("2025-05-13T08:17:15Z"));
        e1.asistir(r1,Instant.parse("2025-05-13T08:17:20Z"));
        int esperado = 3;
        assertEquals(3,r1.obtenerTotalAsistencia());
        Organizador o2 =new Organizador("201","Parra Olivarez","Lucas","lucasparra@gmail.com");
        Reunion r2 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(),Instant.parse("2025-05-13T08:17:00Z"),26.0f,"A2",o2);
        r2.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        r2.finalizar(Instant.parse("2025-05-14T10:17:00Z"));
        float esperado1 = 0.0f;
        assertEquals(esperado1,r2.obtenerTotalAsistencia());

    }

    @Test
    void obtenerPorcentajeAsistencia() throws IOException, ReunionFinalizada, ReunionNoEmpieza {
        Organizador o1 = new Organizador("101","Mora Muñoz","Pedro","pedromora@gmail.com");
        Empleado e1 = new Empleado("102","Chavez Hernandez","Carlos","carloschavez@gmail.com");
        Empleado e3= new Empleado ("104","Parra Muñoz","Pablo","pablomuñoz@gmail.com");
        Empleado e2 = new Empleado("103","Chavez Zapata","Maria","mariachavez@gmail.com");
        Reunion r1 = new ReunionPresencial(tipoReunion.TECNICA, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"),1.5f ,"A1",o1);
        Departamento d1 = new Departamento("Departamento B");
        d1.addEmpleado(e1);
        d1.addEmpleado(o1);
        d1.addEmpleado(e2);
        d1.addEmpleado(e3);
        d1.invitar(r1.getInvitacion());
        r1.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        o1.asistir(r1,Instant.parse("2025-05-13T08:17:10Z"));
        e2.asistir(r1,Instant.parse("2025-05-13T08:17:15Z"));
        e1.asistir(r1,Instant.parse("2025-05-13T08:17:15Z"));
        r1.finalizar(Instant.parse("2025-05-13T09:47:00Z"));
        float esperado = 75.0f;
        assertEquals(esperado,r1.obtenerPorcentajeAsistencia());

        Organizador o2 =new Organizador("201","Parra Olivarez","Lucas","lucasparra@gmail.com");
        Reunion r2 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(),Instant.parse("2025-05-13T08:17:00Z"),26.0f,"A2",o2);
        r2.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        r2.finalizar(Instant.parse("2025-05-14T10:17:00Z"));
        float esperado1 = 0.0f;
        assertEquals(esperado1,r2.obtenerPorcentajeAsistencia());


    }

    @Test
    void obtenerRetrasos() throws IOException, ReunionFinalizada, ReunionNoEmpieza {
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
        assertEquals(listaRetrasoEsperada,r1.obtenerRetrasos());

        Organizador o2 = new Organizador("201", "Parra Olivarez", "Lucas", "lucasparra@gmail.com");
        Empleado e3 = new Empleado("104", "Chavez Zapata", "Javier", "chavezzapata@gmail.com");
        Reunion r2 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"), 26.0f, "A2", o2);
        r2.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        e3.invitar(r2.getInvitacion());
        e3.asistir(r2, Instant.parse("2025-05-13T08:17:00Z"));
        r2.finalizar(Instant.parse("2025-05-14T10:17:00Z"));
        ArrayList<String> listaRetrasoEsperada2 = new ArrayList<>();
        assertEquals(listaRetrasoEsperada2,r2.obtenerRetrasos());


    }

    @Test
    void calcularTiempoReal() throws IOException {
        Organizador o1 = new Organizador("101","Mora Muñoz","Pedro","pedromora@gmail.com");
        Reunion r1 = new ReunionPresencial(tipoReunion.TECNICA, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"),2.0f ,"A1",o1);
        r1.iniciar(Instant.parse("2025-05-13T23:00:00Z"));
        r1.finalizar(Instant.parse("2025-05-14T01:00:00Z"));
        float r1esperado = 2.0f;
        Organizador o2 =new Organizador("201","Parra Olivarez","Lucas","lucasparra@gmail.com");
        Reunion r2 = new ReunionPresencial(tipoReunion.OTRO, LocalDate.now(),Instant.parse("2025-05-13T08:17:00Z"),26.0f,"A2",o2);
        r2.iniciar(Instant.parse("2025-05-13T08:17:00Z"));
        r2.finalizar(Instant.parse("2025-05-14T10:17:00Z"));
        float r2esperado = 26.0f;
        Organizador o3 = new Organizador("301","Ramirez Vidal","Emanuel","emanuelramirez@gmail.com");
        Reunion r3 = new ReunionVirtual(tipoReunion.MARKETING,LocalDate.now(),Instant.parse("2025-05-13T08:17:00Z"),0.45f,"meet.r3.com",o3);
        r3.iniciar(Instant.parse("2025-05-13T08:15:00Z"));
        r3.finalizar(Instant.parse("2025-05-13T09:00:00Z"));
        float r3esperado = 0.75f;
        assertEquals(r1esperado,r1.calcularTiempoReal());
        assertEquals(r2esperado,r2.calcularTiempoReal());
        assertEquals(r3esperado,r3.calcularTiempoReal());
    }
}