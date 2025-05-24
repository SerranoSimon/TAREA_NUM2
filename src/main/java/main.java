import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.HOURS;

public class main {
    public static void main(String[] args) throws ReunionFinalizada, ReunionNoEmpieza, IOException {
        Organizador e1=new Organizador("2","placencia","wlaid","wwliad.com");
        Empleado e2=new Empleado("0","ss","dd","2m");
        Departamento dep1=new Departamento("informatica");
        dep1.addEmpleado(e2);
        dep1.addEmpleado(e1);
        System.out.println(dep1);




    }
}
