import java.util.ArrayList;

public class Departamento {
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
}