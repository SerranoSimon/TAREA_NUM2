import java.util.ArrayList;

public class Departamento implements Invitable {
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
    public void invitar( Reunion reunion) {
        for(Empleado e: empleados){
            reunion.getListaInvitados().add(e);
        }
    }
}