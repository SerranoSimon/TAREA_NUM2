import java.time.Instant;
import java.util.ArrayList;

public class Departamento implements Invitable, Asistible{
    private String nombre;
    private ArrayList<Empleado> empleados =new ArrayList<>();

    public Departamento(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    @Override
    public void invitar(Invitacion invitacion) {
        for(Empleado e: empleados){
            invitacion.getListaDeInvitados().add(e);
        }
    }

    @Override
    public void asistir(Reunion reunion, Instant horaLLegada) {
        for(Empleado e: empleados){
            reunion.getAsistencia().getListaDeAsistencia().add(e);
        }
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}