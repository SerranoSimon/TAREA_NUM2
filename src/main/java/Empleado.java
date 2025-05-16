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
