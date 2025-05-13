import java.time.Instant;

public class Empleado implements Invitable, Asistible{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    public Empleado(String id, String apellidos, String nombre, String correo){
        this.id=id;
        this.apellidos=apellidos;
        this.nombre=nombre;
        this.correo=correo;
    }
    public String getId(){
        return id;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCorreo(){
        return correo;
    }

    @Override
    public void invitar(Invitacion invitacion) {
        invitacion.getListaDeInvitados().add(this);

    }

    @Override
    public void asistir(Asistencia asistencia) {
        asistencia.getListaDeAsistencia().add(this);
    }
}
