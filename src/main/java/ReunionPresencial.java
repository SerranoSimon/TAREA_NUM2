import java.io.IOException;
import java.time.*;
import java.util.ArrayList;

/**
 *Clase que hereda de Reunion, representa una reunión presencial.
 */
public class ReunionPresencial extends Reunion {
    private String sala;
    private Invitacion invitacion;

    /**
     *
     * @param tipoReunion tipo de reunion (MARKETING, TECNICA, OTRO)
     * @param fecha fecha de la reunion
     * @param horaPrevista hora a la que debería comenzar la reunión.
     * @param duracionPrevista duración estimada de la reunión.
     * @param sala sala en la que se hará la reunión.
     * @param organizador empleado organizador de la reunión.
     * @throws IOException Si ocurre un error relacionado a la creación del archivo de notas.
     */
    public ReunionPresencial(tipoReunion tipoReunion,LocalDate fecha, Instant horaPrevista,
                             Duration duracionPrevista,String sala, Organizador organizador) throws IOException {
        super(tipoReunion,fecha, horaPrevista, duracionPrevista, organizador);
        this.sala=sala;
        this.invitacion=new InvitacionPresencial(horaPrevista,fecha,duracionPrevista,tipoReunion,sala);
        invitacion.getListaDeInvitados().add(organizador);

    }


    @Override
    public Invitacion getInvitacion() {
        return invitacion;
    }

    /**
     *
     * @return retorna información relevante acerca de la reunión presencial, incluyendo la sala de esta.
     */
    @Override
    public String toString() {
        return "[Reunion Presencial: "+
                super.toString()+
                ", Lugar: sala "+sala+"]";
    }
}
