import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {

    @Test
    void invitar() throws ReunionFinalizada, ReunionNoEmpieza, IOException {
        /**
         * caso de uso normal donde se presenta la capacidad para invitar un departamento completo.
         */
        Organizador o1 = new Organizador("101","Mora Muñoz","Pedro","pedromora@gmail.com");
        Empleado e1 = new Empleado("102","Chavez Hernandez","Carlos","carloschavez@gmail.com");
        Empleado e2 = new Empleado("103","Chavez Zapata","Maria","mariachavez@gmail.com");
        Reunion r1 = new ReunionPresencial(tipoReunion.TECNICA, LocalDate.now(), Instant.parse("2025-05-13T08:17:00Z"),1.5f ,"A1",o1);
        Departamento d1 = new Departamento("Departamento B");
        d1.addEmpleado(e1);
        d1.addEmpleado(o1);
        d1.addEmpleado(e2);

        d1.invitar(r1.getInvitacion());

        ArrayList<Persona> listaEsperada = new ArrayList<>();
        listaEsperada.add(o1);
        listaEsperada.add(e1);
        listaEsperada.add(e2);
        assertEquals(listaEsperada,r1.getInvitacion().getListaDeInvitados());


    }

    @Test
    void obtenerCantidadEmpleados() {
        /**
         * caso de uso normal
         */
        Empleado e1 = new Empleado("102","Chavez Hernandez","Carlos","carloschavez@gmail.com");
        Empleado e2 = new Empleado("103","Chavez Zapata","Maria","mariachavez@gmail.com");
        Empleado e3= new Empleado ("104","Parra Muñoz","Pablo","pablomuñoz@gmail.com");
        Departamento d2 = new Departamento("Departamento C");
        d2.addEmpleado(e1);
        d2.addEmpleado(e2);
        d2.addEmpleado(e3);
        int esperado = 3;
        assertEquals(esperado,d2.obtenerCantidadEmpleados());
        /**
         * caso donde se crea un departamento y no se agrega a ningún empleado
         */
        Departamento d3 = new Departamento("Departamento D");
        int esperado1= 0;
        assertEquals(esperado1,d3.obtenerCantidadEmpleados());


    }
}