import java.time.Instant;

/**
 *Clase que representa a un empleado que puede ser invitado a reuniones y asistir a ellas a tiempo, con retraso o no asistir.
 */
public class Empleado implements Invitable, Asistible{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    /**
     * constructor del empleado con su información relevante.
     * @param id ID del empleado.
     * @param apellidos apellidos del empleado.
     * @param nombre nombre del empleado.
     * @param correo correo del empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo){
        this.id=id;
        this.apellidos=apellidos;
        this.nombre=nombre;
        this.correo=correo;
    }

    /**
     * metodo para obtener el id del empleado.
     * @return retorna el id de un empleado en concreto.
     */
    public String getId(){
        return id;
    }

    /**
     *metodo para obtener los apellidos del empleado.
     * @return retorna los apellidos de un empleado en concreto.
     */
    public String getApellidos(){
        return apellidos;
    }

    /**
     *metodo para obtener el nombre del empleado.
     * @return retorna el nombre de un empleado en concreto.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     *metodo para obtener el correo del empleado.
     * @return retorna el correo de un empleado en concreto.
     */
    public String getCorreo(){
        return correo;
    }

    /**
     *permite la adición de un empleado a la lista de invitados de una reunión.
     * @param invitacion se agrega a la lista de invitados.
     */
    @Override
    public void invitar(Invitacion invitacion) {
        invitacion.getListaDeInvitados().add(this);

    }

    /**
     *se controla la asistencia de un empleado en concreto, indicando si ha llegado antes de que comience la reunión o cuando ya ha terminado.
     * @param reunion reunión a la que asiste
     * @param horaLLegada hora a la que el empleado ha llegado a la reunión.
     * @throws ReunionFinalizada en caso de que el empleado llegó cuando la reunión ya había finalizado.
     * @throws ReunionNoEmpieza en caso de que el empleado llegó cuando la reunión todavía no había comenzado.
     */

    @Override
    public void asistir(Reunion reunion, Instant horaLLegada) throws ReunionFinalizada, ReunionNoEmpieza {
        if(reunion.getHoraInicio()==null){
            throw new ReunionNoEmpieza("Estimado/a "+nombre+apellidos+", ha llegado antes, la reunion aún no empieza.");
        }
        if(reunion.getHoraFin()==null){
            reunion.getAsistencia().getListaDeAsistencia().add(this);
            reunion.getAsistencia().setLlegada(horaLLegada);
        }
        else{
            throw new ReunionFinalizada("Estimado/a "+nombre+apellidos+", ha llegado tarde, la reunión finalizó.");
        }
    }

    /**
     *Su objetivo es que la información del empleado sea visible.
     * @return retorna la información del empleado.
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
