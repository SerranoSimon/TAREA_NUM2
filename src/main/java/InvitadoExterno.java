import java.time.Instant;

/**
 * Clase que representa invitados externos que pueden asistir a reuniones. Hereda de clase Persona.
 */
public class InvitadoExterno extends Persona implements Invitable,Asistible{
    /**
     *Constructor que crea un invitado con su información correspondiente.
     * @param nombre nombre del invitado externo.
     * @param apellidos apellidos del invitado externo.
     * @param correo correo del invitado externo.
     */
    public InvitadoExterno(String nombre,String apellidos,String correo){
        super(nombre,apellidos,correo);

    }

    /**
     *
     * @param reunion se refiere a la reunión a la que se asiste.
     * @param horaLLegada se refiere a la hora a la que llega el empleado.
     * @throws ReunionNoEmpieza en caso de que llegue antes del comienzo de la reunión.
     * @throws ReunionFinalizada en caso de que llegue cuando la reunión ya finalizó.
     * @throws AsisteSinSerInvitado en caso de que se intente asistir a una reunión donde no ha sido invitado.
     */
    @Override
    public void asistir(Reunion reunion, Instant horaLLegada) throws
            ReunionNoEmpieza, ReunionFinalizada, AsisteSinSerInvitado{
        boolean presente= reunion.obtenerAsistencias().stream().anyMatch(persona -> persona==this);
        if(presente){
            return;
        }

        if(reunion.getInvitacion().getListaDeInvitados().stream().anyMatch(persona -> persona==this)){
            if(reunion.getHoraInicio()==null){
                throw new ReunionNoEmpieza("Estimado/a "+getNombre()+getApellidos()+", ha llegado antes, la reunion aún no empieza.");
            }
            if(reunion.getHoraFin()==null){
                reunion.getAsistencia().getListaDeAsistencia().add(this);
                reunion.getAsistencia().setLlegada(horaLLegada);
            }
            else{
                throw new ReunionFinalizada("Estimado/a "+getNombre()+getApellidos()+", ha llegado tarde, la reunión finalizó.");
            }
        }
        else{
            throw new AsisteSinSerInvitado("Estimado/a "+getNombre()+getApellidos()+", no puede asistir a esta reunion ya que no está invitado");
        }

    }

    /**
     *
     * @param invitacion invitación a la reunión.
     */
    @Override
    public void invitar(Invitacion invitacion) {
        boolean estaiInvitado=invitacion.getListaDeInvitados().stream().anyMatch(persona -> persona==this);
        if(!estaiInvitado){
            invitacion.getListaDeInvitados().add(this);
        }
    }

    /**
     *
     * @return información del invitado externo.
     */
    @Override
    public String toString() {
        return "[InvitadoExterno" +
                super.toString();
    }
}
