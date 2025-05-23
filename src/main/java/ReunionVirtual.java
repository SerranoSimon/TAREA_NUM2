import java.io.IOException;
import java.time.*;
import java.util.ArrayList;

/**
 *Clase que hereda de reunión, representa una reunión virtual.
 */
public class ReunionVirtual extends Reunion{
    private String enlace;
    private Invitacion invitacion;

    /**
     *
     * @param tipoReunion tipo de reunión (MARKETING, TECNINA, OTRO).
     * @param fecha se refiere a la fecha de la reunión.
     * @param horaPrevista es la hora a la que debería comenzar la reunión.
     * @param duracionPrevistaHoras duración estimada de la reunión.
     * @param enlace enlace de la reunión virtual.
     * @param organizador empleado organizador de la reunión.
     * @throws IOException si ocurre un error relacionado a la creación del archivo de notas.
     */
    public ReunionVirtual(tipoReunion tipoReunion,LocalDate fecha, Instant horaPrevista,
                          float duracionPrevistaHoras,String enlace, Organizador organizador) throws IOException {
        super(tipoReunion,fecha, horaPrevista, duracionPrevistaHoras, organizador);
        this.enlace=enlace;
        this.invitacion=new InvitacionVirtual(horaPrevista,fecha,duracionPrevistaHoras,tipoReunion,enlace);
        invitacion.getListaDeInvitados().add(organizador);
    }
    @Override
    public Invitacion getInvitacion() {
        return invitacion;
    }

    /**
     *
     * @return retorna información relevante acerca de la reunión virtual, incluye el enlace o link.
     */
    @Override
    public String toString() {
        return "[Reunion Virtual: "+
                super.toString()+
                ", Enlace "+enlace+"]";
    }
    public ArrayList<Persona> obtenerInvitados(){
        return invitacion.getListaDeInvitados();}
}
