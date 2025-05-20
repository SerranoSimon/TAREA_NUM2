import java.time.Instant;

public class InvitadoExterno extends Persona implements Invitable,Asistible{
    public InvitadoExterno(String nombre,String apellidos,String correo){
        super(nombre,apellidos,correo);

    }
    @Override
    public void asistir(Reunion reunion, Instant horaLLegada) throws
            ReunionNoEmpieza, ReunionFinalizada {
            reunion.getAsistencia().getListaDeAsistencia().add(this);

    }

    @Override
    public void invitar(Invitacion invitacion) {
        invitacion.getListaDeInvitados().add(this);

    }

    @Override
    public String toString() {
        return "InvitadoExterno{" +
                "nombre='" + getNombre() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                '}';
    }
}
