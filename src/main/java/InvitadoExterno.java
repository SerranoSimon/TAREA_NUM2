import java.time.Instant;

public class InvitadoExterno extends Persona implements Invitable,Asistible{
    public InvitadoExterno(String nombre,String apellidos,String correo){
        super(nombre,apellidos,correo);

    }
    @Override
    public void asistir(Reunion reunion, Instant horaLLegada) throws
            ReunionNoEmpieza, ReunionFinalizada, AsisteSinSerInvitado{
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

    @Override
    public void invitar(Invitacion invitacion) {
        invitacion.getListaDeInvitados().add(this);

    }

    @Override
    public String toString() {
        return "[InvitadoExterno" +
                super.toString();
    }
}
