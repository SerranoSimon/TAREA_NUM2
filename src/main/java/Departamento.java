import java.time.Instant;
import java.util.ArrayList;

/**
 * Clase que representa un departamento donde pueden haber múltiples empleados.
 */
public class Departamento implements Invitable{

    private String nombre;
    private ArrayList<Empleado> empleados =new ArrayList<>();

    /**
     *Crea un nuevo departamento con un nombre correspondiente.
     * @param nombre se refiere al nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    /**
     * obtiene el nombre del departamento.
     * @return retorna el nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Agrega un empleado al departamento.
     * @param empleado se refiere al empleado a agregar.
     */
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    /**
     * obtiene la cantidad de empleados para cada departamento.
     * @return retorna la cantidad de empleados en el departamento.
     */
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    /**
     *Para cada empleado en el departamento, se le agrega a la lista de invitados.
     * @param invitacion representa una invitación para los empleados.
     */
    @Override
    public void invitar(Invitacion invitacion) {
        for(Empleado e: empleados){
            invitacion.getListaDeInvitados().add(e);
        }
    }

    /**
     *
     * @return retorna texto descriptivo del departamento, indicando su nombre.
     */
    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}