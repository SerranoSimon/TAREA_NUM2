import java.time.Instant;

/**
 *Clase que representa a un empleado que puede ser invitado y asistir a reuniones. Hereda de Persona.
 */
public class Empleado extends Persona implements Invitable, Asistible{
    private String id;

    /**
     * constructor del empleado con su información relevante.
     * @param id ID del empleado.
     * @param apellidos apellidos del empleado.
     * @param nombre nombre del empleado.
     * @param correo correo del empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo){
        super(nombre,apellidos,correo);
        this.id=id;

    }

    /**
     * metodo para obtener el id del empleado.
     * @return retorna el id de un empleado en concreto.
     */
    public String getId(){
        return id;
    }


    /**
     *permite la adición de un empleado a la lista de invitados de una reunión.
     * @param invitacion se agrega a la lista de invitados.
     */
    @Override
    public void invitar(Invitacion invitacion) {
        boolean estaInvitado=invitacion.getListaDeInvitados().stream().anyMatch(persona -> persona==this);
        if(!estaInvitado){
            invitacion.getListaDeInvitados().add(this);
        }
    }

    /**
     *se controla la asistencia de un empleado en concreto, indicando si ha llegado antes de que comience la reunión,
     * durante la reunion o cuando ya finalizó, también ve si ya está presente.
     * @param reunion reunión a la que asiste
     * @param horaLLegada hora a la que el empleado ha llegado a la reunión.
     * @throws ReunionFinalizada en caso de que el empleado llegó cuando la reunión ya había finalizado.
     * @throws ReunionNoEmpieza en caso de que el empleado llegó cuando la reunión todavía no había comenzado.
     */

    @Override
    public void asistir(Reunion reunion, Instant horaLLegada) throws ReunionFinalizada, ReunionNoEmpieza,
            AsisteSinSerInvitado{
        boolean presente= reunion.obtenerAsistencias().stream().anyMatch(persona -> persona==this);
        if(presente){
            return;
        }
        if(reunion.obtenerInvitados().stream().anyMatch(persona -> persona==this)){
            if(reunion.getHoraInicio()==null){
                throw new ReunionNoEmpieza("Estimado/a "+getNombre()+" "+getApellidos()+", ha llegado antes, la reunion aún no empieza.");
            }
            if(reunion.getHoraFin()==null){
                reunion.obtenerAsistencias().add(this);
                reunion.getAsistencia().Llegada(horaLLegada);
            }
            else{
                throw new ReunionFinalizada("Estimado/a "+getNombre()+" "+getApellidos()+", ha llegado tarde, la reunión finalizó.");
            }
        }
        else{
            throw new AsisteSinSerInvitado("Estimado/a "+getNombre()+" "+getApellidos()+", no puede asistir a esta reunion ya que no está invitado");
        }

    }
    /**
     *Su objetivo es que la información del empleado sea visible.
     * @return retorna la información del empleado.
     */
    @Override
    public String toString() {
        return "[Empleado: " +
                "ID= "+ id+","+
                super.toString()+"]";

    }
}
